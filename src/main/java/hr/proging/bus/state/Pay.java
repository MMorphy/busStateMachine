package hr.proging.bus.state;

import java.util.HashMap;
import java.util.Map;

public class Pay extends StateBase {
	static Map<String, StateBase> inputMap = null;

	public Pay() {
		super("pay", initMap());
	}

	public static Map<String, StateBase> initMap() {
		if (inputMap == null) {
			inputMap = new HashMap<String, StateBase>();
			inputMap.put("paid", new PrintTicket());
			inputMap.put("notpaid", new Pay());
			inputMap.put("cancel", new PickBus());
			inputMap.put("notcancel", new Pay());
		}
		return inputMap;
	}
}
