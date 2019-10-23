package hr.proging.bus.main;

import java.util.Scanner;

import hr.proging.bus.state.StateBase;

public class App {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String currentInput;
		while (true) {
			System.out.println("Current state: " + StateBase.currentState.getStateName());
			System.out.print("Input: ");
			currentInput = input.nextLine();
			StateBase.handleInput(currentInput);
		}
	}

}
