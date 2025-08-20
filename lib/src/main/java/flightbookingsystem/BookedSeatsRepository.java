package flightbookingsystem;

import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookedSeatsRepository extends JpaRepository<BookedSeat, Long> {
	public Map<Long, Integer> getFlightScheduleWiseBookedSeatsCount(Iterable<Long> flightScheduleIds);
}
