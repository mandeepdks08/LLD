package movieticketbooking;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BookedSeatsRepository extends JpaRepository<BookedSeat, Long> {
	public List<BookedSeat> findByShowId(Long showId);

	@Query(value = "SELECT seatid FROM bookedseats bs WHERE showid = :showId AND seatid IN :seatIds")
	public List<Long> getBookedSeatIdsForShowIdAndSeatIdsIn(Long showId, List<Long> seatIds);
}
