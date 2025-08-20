package flightbookingsystem;

import lombok.Getter;

@Getter
public class BookedSeat {
	private Long id;
	private Long bookingId;
	private Long flightScheduleId;
	private String seatId;
}
