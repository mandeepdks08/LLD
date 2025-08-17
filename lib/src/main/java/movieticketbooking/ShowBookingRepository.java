package movieticketbooking;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowBookingRepository extends JpaRepository<ShowBooking, Long> {
	public List<ShowBooking> findByShowId(Long showId);
	
}
