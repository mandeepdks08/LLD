package flightbookingsystem;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class SimpleFlightSearchManager implements FlightSearchManager {

	private final FlightScheduleRepository flightScheduleRepo;
	private final AircraftRepository aircraftRepo;
	private final BookedSeatsRepository bookedSeatsRepo;

	public SimpleFlightSearchManager(FlightScheduleRepository flightScheduleRepo, AircraftRepository aircraftRepo,
			BookedSeatsRepository bookedSeatsRepo) {
		this.flightScheduleRepo = flightScheduleRepo;
		this.aircraftRepo = aircraftRepo;
		this.bookedSeatsRepo = bookedSeatsRepo;
	}

	@Override
	public List<FlightSchedule> searchFlights(FlightSearchRequest request) {
		List<FlightSchedule> availableFlights = flightScheduleRepo.searchAvailableFlights(request.getSource(),
				request.getDestination(), request.getDepartureDate());
		filterBasedOnNumberOfSeatsAvailable(availableFlights, request.getNumberOfPassengers());
		return availableFlights;
	}

	private void filterBasedOnNumberOfSeatsAvailable(List<FlightSchedule> availableFlights, int requiredSeats) {
		Map<Long, Integer> aircraftWiseTotalSeats = aircraftRepo
				.findAllById(availableFlights.stream().map(FlightSchedule::getAircraftId).collect(Collectors.toSet()))
				.stream().collect(Collectors.toMap(a -> a.getId(), a -> a.getNumberOfSeats(), (e1, e2) -> e2));
		Map<Long, Integer> flightScheduleWiseBookedSeatsCount = bookedSeatsRepo.getFlightScheduleWiseBookedSeatsCount(
				availableFlights.stream().map(FlightSchedule::getId).collect(Collectors.toList()));

		availableFlights.removeIf(flight -> {
			Integer totalAircraftSeats = aircraftWiseTotalSeats.get(flight.getAircraftId());
			Integer totalBookedSeats = flightScheduleWiseBookedSeatsCount.get(flight.getId());
			Integer availableSeats = totalAircraftSeats - totalBookedSeats;
			return availableSeats < requiredSeats;
		});
	}

}
