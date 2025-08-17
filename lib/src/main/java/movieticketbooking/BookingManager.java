package movieticketbooking;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.transaction.annotation.Transactional;

import movieticketbooking.exceptions.SeatAlreadyBookedException;

public class BookingManager {

	private final ShowBookingRepository showBookingRepo;
	private final BookedSeatsRepository bookedSeatsRepo;
	private final SeatRepository seatRepo;

	public BookingManager(ShowBookingRepository showBookingRepo, BookedSeatsRepository bookedSeatsRepo,
			SeatRepository seatRepo) {
		this.showBookingRepo = showBookingRepo;
		this.bookedSeatsRepo = bookedSeatsRepo;
		this.seatRepo = seatRepo;
	}

	public void doBooking(Long showId, Long customerId, List<Long> seatIds) {
		try {
			ShowBooking booking = ShowBooking.builder().showId(showId).customerId(customerId).build();
			List<BookedSeat> seatsToBook = seatIds.stream()
					.map(seatId -> BookedSeat.builder().showId(showId).seatId(seatId).build())
					.collect(Collectors.toList());
			doBooking(booking, seatsToBook);
		} catch (DataIntegrityViolationException e) {
			List<Long> alreadyBookedSeats = bookedSeatsRepo.getBookedSeatIdsForShowIdAndSeatIdsIn(showId, seatIds);
			if (CollectionUtils.isNotEmpty(alreadyBookedSeats)) {
				List<Seat> seats = seatRepo.findBySeatIdIn(seatIds);
				List<String> seatIdentifiers = seats.stream().map(seat -> seat.getRow() + seat.getSeatNumber())
						.collect(Collectors.toList());
				throw new SeatAlreadyBookedException(seatIdentifiers);
			}
			throw e;
		}
	}

	@Transactional
	private void doBooking(ShowBooking booking, List<BookedSeat> seatsToBook) {
		showBookingRepo.save(booking);
		bookedSeatsRepo.saveAll(seatsToBook);
	}

}
