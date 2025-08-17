package movieticketbooking;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class SimpleListShowsStrategy implements ListShowStrategy {

	private final ShowRepository showRepo;

	public SimpleListShowsStrategy(ShowRepository showRepo) {
		this.showRepo = showRepo;
	}

	@Override
	public List<Show> listUpcomingShows() {
		List<Show> upcomingShows = showRepo.findUpcomingShows(LocalDate.now(), LocalTime.now());
		return upcomingShows;
	}

	@Override
	public List<Show> listUpcomingShowsByShowName(String showName) {
		List<Show> upcomingShows = showRepo.findUpcomingShowsByShowName(LocalDate.now(), LocalTime.now(), showName);
		return upcomingShows;
	}

}
