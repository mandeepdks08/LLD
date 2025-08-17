package movieticketbooking;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "bookedseats")
@Getter
@Setter
@Builder
public class BookedSeat {
	private Long showId;
	private Long seatId;
	
	// UNIQUE {showid, seatid}
}
