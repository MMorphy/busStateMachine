package hr.proging.bus.state;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class StateBase {

	public static List<String> busses = null;

	public static Map<String, List<String>> bussesToSeats = null;

	private String stateName;

	public static StateBase currentState = new PickBus();

	public static String pickedBus = null;

	public static String pickedSeat = null;

	private Map<String, StateBase> inputToNextState;

	public static void handleInput(String input) {
		if (input == null) {
			return;
		}
		if (StateBase.currentState.getInputToNextState().containsKey(input.toLowerCase())) {
			StateBase.currentState = StateBase.currentState.getInputToNextState().get(input);
			if (StateBase.currentState instanceof PickSeat) {
				pickedBus = input;
			} else if (StateBase.currentState instanceof Pay) {
				pickedSeat = input;
			} else if (StateBase.currentState instanceof PrintTicket) {
				StateBase.removeSeat(pickedBus, pickedSeat);
				pickedBus = "";
				pickedSeat = "";
			}
		} else {
			System.out.println("Invalid input for this state!");
			System.out.println("Valid states:");
			for (String key : currentState.getInputToNextState().keySet()) {
				System.out.println(key);
			}
		}
	}

	public static void populateBusses() {
		if (StateBase.busses == null) {
			StateBase.busses = new ArrayList<>();
			busses.add("bus1");
			busses.add("bus2");
			busses.add("bus3");
		}
	}

	public static void populateSeats() {
		if (StateBase.bussesToSeats == null) {
			StateBase.bussesToSeats = new HashMap<String, List<String>>();
			for (String bus1 : StateBase.busses) {
				List<String> seat = new ArrayList<String>();
				seat.add("seat1");
				seat.add("seat2");
				seat.add("seat3");
				seat.add("seat4");
				seat.add("seat5");
				StateBase.bussesToSeats.put(bus1, seat);
			}
		}
	}

	private static void removeSeat(String bus, String seat) {
			List<String> seats = StateBase.bussesToSeats.get(bus);
			seats.remove(seat);
			StateBase.bussesToSeats.put(bus, seats);
			PickSeat.removeSet(bus, seat);
	}

	public StateBase(String stateName, Map<String, StateBase> inputToNextState) {
		this.stateName = stateName;
		this.inputToNextState = inputToNextState;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public Map<String, StateBase> getInputToNextState() {
		return inputToNextState;
	}

	public void setInputToNextState(Map<String, StateBase> inputToNextState) {
		this.inputToNextState = inputToNextState;
	}
}
