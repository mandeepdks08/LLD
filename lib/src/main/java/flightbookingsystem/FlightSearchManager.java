package flightbookingsystem;

import java.util.List;

public interface FlightSearchManager {
	public List<FlightSchedule> searchFlights(FlightSearchRequest request);
}
