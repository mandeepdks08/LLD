package flightbookingsystem;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookedPassengerDetailRepository extends JpaRepository<BookedPassengerDetail, Long> {
	
}
