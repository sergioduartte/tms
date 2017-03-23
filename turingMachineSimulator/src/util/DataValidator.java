package util;

import java.util.List;

import exceptions.DirectionPatternException;
import exceptions.StateNotFoundException;
import exceptions.StatePatternException;
import turingMachineSimulator.machine.State;

public class DataValidator {

	public static void commandValidator(String[] commands) throws StatePatternException, DirectionPatternException {
		/*
		 * boolean hasQ0 = false; boolean hasQA = false; // vai pra quando for
		 * passar por todos os estados... boolean hasQR = false;
		 */

		String statePattern = "q(\\w+)";
		String directionPattern = "[l,r]";

		if (!commands[0].matches(statePattern)) {
			throw new StatePatternException();

		}
		if (!commands[3].matches(directionPattern)) {
			throw new DirectionPatternException();

		}
	}

	public static void commandsValidator(List<State> states) throws StateNotFoundException{

		boolean hasQ0 = false;
		boolean hasQA = false; // vai pra quando for passar por todos os
								// estados...
		boolean hasQR = false;

		for (State state : states) {
			if (state.getName().equalsIgnoreCase("q0")) {
				hasQ0 = true;
			}

			if (state.getName().equalsIgnoreCase("qa")) {
				hasQA = true;
			}
			if (state.getName().equalsIgnoreCase("qr")) {
				hasQR = true;
			}
		}
		
	if (hasQ0 == false) {
		throw new StateNotFoundException("initial");
	}
	
	if (hasQA == false) {
		throw new StateNotFoundException("acceptance");
	}
	
	if (hasQR == false) {
		throw new StateNotFoundException("rejection");
	}
	
	
	
	}

}
