package linkedhashmap;

import java.util.Map;

public class Main {
	public static void main(String[] args) {
		LinkedHashMap<String, Integer> weekDays = new LinkedHashMap<>();
		weekDays.put("Monday", 1);
		weekDays.put("Tuesday", 2);
		weekDays.put("Wednesday", 3);
		
		for (Map.Entry<String, Integer> entry: weekDays.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
		
		weekDays.put("Tuesday", 2);
		
		for (Map.Entry<String, Integer> entry: weekDays.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
		
		weekDays.remove("Wednesday");
		
		for (Map.Entry<String, Integer> entry: weekDays.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
	}
}
