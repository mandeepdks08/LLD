package movieticketbooking;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowRepository extends JpaRepository<Show, Long> {
	public Show findByShowId(Long showId);
	
	public List<Show> findByShowName(String showName);

	@Query(value = "SELECT * FROM SHOWS WHERE showdate >= :showDateGTE AND starttime > :timeGT ORDER BY showdate, starttime ASC", nativeQuery = true)
	public List<Show> findUpcomingShows(LocalDate showDateGTE, LocalTime timeGT);

	@Query(value = "SELECT * FROM SHOWS WHERE showdate >= :showDateGTE AND starttime > :timeGT AND showname = :showName ORDER BY showdate, starttime ASC", nativeQuery = true)
	public List<Show> findUpcomingShowsByShowName(LocalDate showDateGTE, LocalTime timeGT, String showName);
}
