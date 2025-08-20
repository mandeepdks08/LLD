package flightbookingsystem;

import java.time.LocalDateTime;

import lombok.Getter;

@Getter
public class FlightSchedule {
	private Long id;
	private Long aircraftId;
	private String source;
	private String destination;
	private LocalDateTime departureTime;
	private LocalDateTime arrivaleTime;
}
