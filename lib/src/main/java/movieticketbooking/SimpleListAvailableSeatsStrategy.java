package movieticketbooking;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class SimpleListAvailableSeatsStrategy implements ListAvailableSeatsStrategy {

	private final ShowRepository showRepo;
	private final SeatRepository seatRepo;
	private final BookedSeatsRepository bookedSeatsRepo;

	public SimpleListAvailableSeatsStrategy(ShowRepository showRepo, SeatRepository seatRepo,
			BookedSeatsRepository bookedSeatsRepo) {
		this.showRepo = showRepo;
		this.seatRepo = seatRepo;
		this.bookedSeatsRepo = bookedSeatsRepo;
	}

	@Override
	public List<Seat> getAvailableSeats(Long showId) {
		List<Seat> allSeats = getTheaterScreenSeatsFromShowId(showId);
		Set<Long> bookedSeatIds = getBookedSeatIds(showId);
		List<Seat> availableSeats = allSeats.stream().filter(seat -> !bookedSeatIds.contains(seat.getSeatId()))
				.collect(Collectors.toList());
		return availableSeats;
	}

	private List<Seat> getTheaterScreenSeatsFromShowId(Long showId) {
		Show show = showRepo.findByShowId(showId);
		Long theaterId = show.getTheaterId();
		Long screenId = show.getScreenId();
		return seatRepo.findByTheaterIdAndScreenId(theaterId, screenId);
	}

	private Set<Long> getBookedSeatIds(Long showId) {
		List<BookedSeat> bookedSeats = bookedSeatsRepo.findByShowId(showId);
		return bookedSeats.stream().map(BookedSeat::getSeatId).collect(Collectors.toSet());
	}

}
