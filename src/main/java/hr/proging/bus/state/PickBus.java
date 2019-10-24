package hr.proging.bus.state;

import java.util.HashMap;
import java.util.Map;

public class PickBus extends StateBase {

	static Map<String, StateBase> inputMap = null;

	public PickBus() {
		super("pickbus", initMap());

		System.out.println("Available busses: ");
		for (String bus : StateBase.busses) {
			System.out.println(bus);
		}
	}

	public static Map<String, StateBase> initMap() {
		StateBase.populateBusses();
		if (inputMap == null) {
			inputMap = new HashMap<String, StateBase>();
			for (String bus : StateBase.busses) {
				inputMap.put(bus, new PickSeat(bus));
			}
		}
		return inputMap;
	}
}
