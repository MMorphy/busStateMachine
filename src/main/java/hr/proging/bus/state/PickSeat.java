package hr.proging.bus.state;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PickSeat extends StateBase {
	static Map<String, List<String>> bussesToAvailSeats = null;
	static Map<String, StateBase> inputMap = null;

	public PickSeat(String bus) {
		super("pick", initMap(bus));
		StateBase.pickedBus = bus;
		System.out.println("Available seats in bus " + StateBase.pickedBus + ": ");
		for (String seat : bussesToAvailSeats.get(bus)) {
			System.out.println(seat);
		}
	}

	public static Map<String, StateBase> initMap(String pickedBus) {
		if (bussesToAvailSeats == null) {
			for (String bus : Waiting.busses) {
				bussesToAvailSeats = new HashMap<String, List<String>>();
				bussesToAvailSeats.put(bus, Arrays.asList("seat1", "seat2", "seat3", "seat4", "seat5"));
			}
		}
		if (inputMap == null) {
			inputMap = new HashMap<String, StateBase>();
			for (String seat : bussesToAvailSeats.get(pickedBus)) {
				inputMap.put(seat, new Pay(seat));
			}
		}
		return inputMap;
	}
}
