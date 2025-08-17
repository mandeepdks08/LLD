package movieticketbooking;

import java.util.List;

public interface ListAvailableSeatsStrategy {
	public List<Seat> getAvailableSeats(Long showId);
}
