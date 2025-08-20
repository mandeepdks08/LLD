package flightbookingsystem;

import org.springframework.stereotype.Service;

@Service
public class SimpleFlightBookingManager implements FlightBookingManager {

	private final FlightBookingRepository flightBookingRepo;

	public SimpleFlightBookingManager(FlightBookingRepository flightBookingRepo) {
		this.flightBookingRepo = flightBookingRepo;
	}

	@Override
	public String book(FlightBookingRequest request) {
		Long bookingId = SnowflakeUniqueIdGenerator.generateUniqueId();
		FlightBooking newBooking = new FlightBooking(bookingId, request.getFlightScheduleId(),
				SystemContext.getUserId());
		flightBookingRepo.save(newBooking);
		
		return null;
	}

}
