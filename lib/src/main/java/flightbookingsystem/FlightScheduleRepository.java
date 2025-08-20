package flightbookingsystem;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightScheduleRepository extends JpaRepository<FlightSchedule, Long> {
	
	@Query(value = "SELECT * FROM flightschedule fs "
			+ "WHERE date(departuretime) = :departureDate "
			+ "AND source = :source "
			+ "AND destination = :destination")
	public List<FlightSchedule> searchAvailableFlights(String source, String destination, LocalDate departureDate);
}
