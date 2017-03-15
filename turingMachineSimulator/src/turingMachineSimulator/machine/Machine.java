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
		
	
	public Machine() {
		this.states = new ArrayList<State>();
		this.inputAlphabet = new ArrayList<String>();
		this.tapeAlphabet = new ArrayList<String>();
		
	}
	
	public void addState(String commandLine) {
		String[] commands = commandLine.split(" ");
		State newState = new State(commands[0]);
		//verifica se o estado atual ja existe nos estados da maquina
		if (! containsState(commands[0])) {
			newState.addTransition(commands[1], commands[2],commands[3],commands[4]);
			states.add(newState);
		} else {
			states.get(states.indexOf(newState)).addTransition(commands[1], commands[2],commands[3],commands[4]);
		}
		
	}

	private boolean containsState(String newState) {
		for (State state : states) {
			if (state.getName().equals(newState)) {
				return true;
			}
		}
		return false;
	}
	
	//aqui eh onde devem estar os testes da sintaxe, se os estados estao escritos da forma correta, nao gerara erro
	public void organizeStates() {
		for (State state : states) {
			if (state.getName().toLowerCase().equals("q0")) {
				this.initialState = state;
			} else if (state.getName().toLowerCase().equals("qa")) {
				this.acceptState = state;
			} else if (state.getName().toLowerCase().equals("qr")) {
				this.rejectState = state;
			}
		}
		
	}
	
	
	
	
	

}
