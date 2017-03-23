package turingMachineSimulator.machine;

import java.util.ArrayList;
import java.util.HashMap;

import exceptions.MissingCommandException;
import util.DataValidator;

public class State {
	
	private String name;
	private HashMap<String, ArrayList<String>>transitionFunctions;

	public State(String name) {
		this.name = name;
		this.transitionFunctions = new HashMap<String, ArrayList<String>>();
	}

	public String getName() {

		return this.name;
	}

	public void addTransition(String inputSymbol, String writeSymbol, String directionSymbol, String newState) {
		//verificar aqui se o estado ja existe
		ArrayList<String> transition = new ArrayList<String>();
		transition.add(writeSymbol);
		transition.add(directionSymbol);
		transition.add(newState);
		
		transitionFunctions.put(inputSymbol,transition);
		
	}
	
	@Override
	public boolean equals(Object obj) {
		State otherState = (State) obj;
		
		return this.getName().equals(otherState.getName());
	}
	
	public String[] processes(String actualInput) throws MissingCommandException {
		
		DataValidator.inputValidator(this , actualInput);
		
		String[] output = new String[3]; //["writeSymbol","directionSymbol","newState",];
		output[0] = this.transitionFunctions.get(actualInput).get(0);
		output[1] = this.transitionFunctions.get(actualInput).get(1);
		output[2] = this.transitionFunctions.get(actualInput).get(2);
		
		return output;
	}

	public HashMap<String, ArrayList<String>> getFunctions() {
		return this.transitionFunctions;
	}

}
