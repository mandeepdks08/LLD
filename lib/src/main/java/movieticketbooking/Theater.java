package movieticketbooking;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "theaters")
@Getter
@Setter
@Builder
public class Theater {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	Long theaterId;
	String name;
	String address;
	List<Screen> screens;
}
