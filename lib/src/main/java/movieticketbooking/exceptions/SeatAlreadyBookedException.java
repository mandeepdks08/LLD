package movieticketbooking.exceptions;

import java.util.List;

public class SeatAlreadyBookedException extends RuntimeException {

	private static final long serialVersionUID = 2635603616061017460L;

	public SeatAlreadyBookedException(List<String> seatIdentifiers) {
		super(String.format("Following seats are already booked - ", String.join(", ", seatIdentifiers)));
	}

}
