package turingMachineSimulator.machine;

import java.util.ArrayList;
import java.util.List;

public class Machine {
	
	private List<State> states;
	private State initialState;
	private State acceptState;
	private State rejectState;
	private List<String> inputAlphabet;
	private List<String> tapeAlphabet;
		
	
	public Machine(List<State> states, State initialState, State acceptState, State rejectState, List<String> inputAlphabet, List<String> tapeAlphabet) {
		this.states = new ArrayList<State>();
		this.acceptState = new State();
		this.rejectState = new State();
		this.inputAlphabet = new ArrayList<String>();
		this.tapeAlphabet = new ArrayList<String>();
		
	}
	
	// PAREI AQUI..................................
	public void addState(String string) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
	

}
