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
@Table(name = "showbookings")
@Getter
@Setter
@Builder
public class ShowBooking {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	Long bookingId;
	Long showId;
	Long customerId;
}
