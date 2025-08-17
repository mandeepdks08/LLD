package movieticketbooking;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "shows")
@Getter
@Setter
@Builder
public class Show {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	Long showId;
	Long theaterId;
	Long screenId;
	String showName;
	LocalDate showDate;
	LocalTime startTime;
	LocalTime endTime;
}
