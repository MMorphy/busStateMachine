package hr.proging.bus.state;

import java.util.HashMap;
import java.util.Map;

public class PickSeat extends StateBase {
	static Map<String, StateBase> inputMap = null;

	public PickSeat(String bus) {
		super("pickseat", initMap(bus));
		StateBase.pickedBus = bus;
		System.out.println("Available seats in bus " + StateBase.pickedBus + ": ");
		for (String seat : StateBase.bussesToSeats.get(bus)) {
			System.out.println(seat);
		}
	}

	public static Map<String, StateBase> initMap(String pickedBus) {
		StateBase.populateSeats();
		if (inputMap == null) {
			inputMap = new HashMap<String, StateBase>();
			for (String seat : StateBase.bussesToSeats.get(pickedBus)) {
				inputMap.put(seat, new Pay());
			}
		}

		return inputMap;
	}
	public static void removeSet(String bus, String seat) {
		inputMap.remove(seat);
	}
}
