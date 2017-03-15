package turingMachineSimulator.machine;

import java.util.ArrayList;
import java.util.List;

public class State {
	
	private String name;
	private List<Transition> transitionFunctions;

	public State(String name) {
		this.name = name;
		this.transitionFunctions = new ArrayList<Transition>();
	}

	public String getName() {

		return this.name;
	}

	public void addTransition(String inputSymbol, String writeSymbol, String directionSymbol, String newState) {
		Transition transition = new Transition(inputSymbol, writeSymbol, directionSymbol, newState);
		
	}
	
}
