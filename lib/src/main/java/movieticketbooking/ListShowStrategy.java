package movieticketbooking;

import java.util.List;

public interface ListShowStrategy {
	public List<Show> listUpcomingShows();

	public List<Show> listUpcomingShowsByShowName(String showName);

}
