package flightbookingsystem;

import lombok.Getter;

@Getter
public class PassengerDetail {
	private String name;
	private Integer age;
	private String address;
	private Meal mealInfo;
	private Baggage baggage;
}
