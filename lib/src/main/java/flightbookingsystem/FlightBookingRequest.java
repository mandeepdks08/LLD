package flightbookingsystem;

import java.util.List;

import lombok.Getter;

@Getter
public class FlightBookingRequest {
	private Long flightScheduleId;
	private List<PassengerDetail> passengerDetails;
}
