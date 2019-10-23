package hr.proging.bus.state;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Waiting extends StateBase {

	static List<String> busses = null;
	static Map<String, StateBase> inputMap = null;

	public Waiting() {
		super("waiting", initMap());
		System.out.println("Available busses: ");
		for (String bus : busses) {
			System.out.println(bus);
		}
	}

	public static Map<String, StateBase> initMap() {
		if (busses == null) {
			busses = new ArrayList<>(Arrays.asList("bus1", "bus2", "bus3"));
		}
		if (inputMap == null) {
			inputMap = new HashMap<String, StateBase>();
			for (String bus : busses) {
				inputMap.put(bus, new PickSeat(bus));
			}
		}
		return inputMap;
	}
}
