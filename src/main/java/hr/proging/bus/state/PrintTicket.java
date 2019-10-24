package hr.proging.bus.state;

import java.util.HashMap;
import java.util.Map;

public class PrintTicket extends StateBase {
	static Map<String, StateBase> inputMap = null;

	public PrintTicket() {
		super("print", initMap());
	}

	public static Map<String, StateBase> initMap() {
		if (inputMap == null) {
			inputMap = new HashMap<String, StateBase>();
			inputMap.put("notpickedup", new PrintTicket());
			inputMap.put("pickedup", new PickBus());
		}
		return inputMap;
	}
}
