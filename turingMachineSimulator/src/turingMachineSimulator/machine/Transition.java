package turingMachineSimulator.machine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Transition {
	
	private HashMap<String, ArrayList<String>> transition;
	
	public Transition(String inputSymbol, String writeSymbol, String directionSymbol, String newState) {
		transition = new HashMap<String, ArrayList<String>>();
		ArrayList<String> args = new ArrayList<String>();
		args.add(writeSymbol);
		args.add(directionSymbol);
		args.add(newState);
		transition.put(inputSymbol,args);
		
	}

	
	
	

}
