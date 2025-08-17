package movieticketbooking;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "seats")
@Getter
@Setter
@Builder
public class Seat {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long seatId;
	private String row;
	private Integer seatNumber;
	private Integer screenId;
	private Integer theaterId;
}
