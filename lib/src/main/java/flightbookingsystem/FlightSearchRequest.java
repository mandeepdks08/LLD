package flightbookingsystem;

import java.time.LocalDate;

import lombok.Getter;

@Getter
public class FlightSearchRequest {
	private String source;
	private String destination;
	private LocalDate departureDate;
	private int numberOfPassengers;

	public FlightSearchRequest(String source, String destination, LocalDate departureDate, int numberOfPassengers) {
		this.source = source;
		this.destination = destination;
		this.departureDate = departureDate;
		this.numberOfPassengers = numberOfPassengers;
	}
	
	
}
