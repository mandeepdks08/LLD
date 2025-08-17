package movieticketbooking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ListShowStrategyFactory {

	@Autowired
	private ShowRepository showRepo;

	public ListShowStrategy getSimpleListShowsStrategy() {
		return new SimpleListShowsStrategy(showRepo);
	}
}
