package turingMachineSimulator.machine;

import java.util.ArrayList;
import java.util.List;

public class Machine {

	private List<State> states;
	private State initialState;
	private State acceptState;
	private State rejectState;
	// private List<String> inputAlphabet; //useless for now
	// private List<String> tapeAlphabet; //useless for now
	private Tape tape;

	public Machine() {
		this.states = new ArrayList<State>();
		// this.inputAlphabet = new ArrayList<String>(); //useless for now
		// this.tapeAlphabet = new ArrayList<String>(); //useless for now
		this.tape = new Tape();

	}

	public void addState(String commandLine) {
		String[] commands = commandLine.split(" ");
		State newState = new State(commands[0]);
		// verifica se o estado atual ja existe nos estados da maquina
		if (!containsState(commands[0])) {
			newState.addTransition(commands[1], commands[2], commands[3], commands[4]);
			states.add(newState);
		} else {
			states.get(states.indexOf(newState)).addTransition(commands[1], commands[2], commands[3], commands[4]);
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

	// aqui eh onde devem estar os testes da sintaxe, se os estados estao
	// escritos da forma correta, nao gerara erro
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

	// retorna se Aceita ou Rejeita a maquina
	public String run() {

		String result = "";
		String actualInput = tape.getPos();
		State actualState = initialState;

		while (true) {

			// retorna um array com o novo simbolo da fita, para que lado andar
			// na fita e o novo estado
			String[] nextSteps = actualState.processes(actualInput);

			String writeSymbol = nextSteps[0];
			this.tape.write(writeSymbol);

			String newDirection = nextSteps[1];
			this.tape.move(newDirection);
			
			actualInput = tape.getPos();
			actualState = getStateByName(nextSteps[2]);

			if (actualState.getName().toLowerCase().equals("qa")) {
				result = "=== ACCEPTED ===";
				break;
			} else if (actualState.getName().toLowerCase().equals("qr")) {
				result = "=== REJECTED ===";
				break;
			}

		}

		return result;

	}

	private State getStateByName(String string) {
		for (State state : this.states) {
			if (state.getName().toLowerCase().equals(string.toLowerCase())) {
				return state;
			}
		}
		return null;
	}

	public void insertOnTape(String input) {
		this.tape.insertOnTape(input);

	}

}
