package flightbookingsystem;

import lombok.Getter;

@Getter
public class FlightBooking {
	private Long bookingId;
	private Long flightScheduleId;
	private Long bookingUserId;

	public FlightBooking(Long bookingId, Long flightScheduleId, Long bookingUserId) {
		this.bookingId = bookingId;
		this.flightScheduleId = flightScheduleId;
		this.bookingUserId = bookingUserId;
	}
}
