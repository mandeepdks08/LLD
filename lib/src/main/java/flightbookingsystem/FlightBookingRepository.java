package flightbookingsystem;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightBookingRepository extends JpaRepository<FlightBooking, Long> {

	public List<FlightBooking> findAllByFlightScheduleId(Iterable<Long> flightScheduleIds);
}
