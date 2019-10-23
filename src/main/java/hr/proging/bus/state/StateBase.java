package hr.proging.bus.state;

import java.util.Map;

public abstract class StateBase {

	private String stateName;

	public static StateBase currentState = new Waiting();

	public static String pickedBus = null;

	public static String picketSeat = null;
	
	private Map<String, StateBase> inputToNextState;

	public static void handleInput(String input) {
		if (input == null) {
			return;
		}
		if (StateBase.currentState.getInputToNextState().containsKey(input.toLowerCase())) {
			StateBase.currentState = StateBase.currentState.getInputToNextState().get(input);
		} else {
			System.out.println("Invalid input for this state!");
			System.out.println("Valid states:");
			for (String key : currentState.getInputToNextState().keySet()) {
				System.out.println(key);
			}
		}
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
