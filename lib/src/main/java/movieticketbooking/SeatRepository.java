package movieticketbooking;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Long> {
	public List<Seat> findByTheaterIdAndScreenId(Long theaterId, Long screenId);
	
	public List<Seat> findBySeatIdIn(List<Long> seatIds);
}
