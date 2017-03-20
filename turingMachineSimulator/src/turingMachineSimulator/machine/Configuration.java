package turingMachineSimulator.machine;

public class Configuration {
	
	private String currentState;
	private String currentTape;
	private String currentSteps;
	
	public Configuration(String currentState, String currentTape, String currentSteps) {
		this.currentState = currentState;
		this.currentTape = currentTape;
		this.currentSteps = currentSteps;
	}
	
	private String[] getConfiguration() {
		String[] saida = new String[3];
		saida[0] = this.currentState;
		saida[1] = this.currentTape;
		saida[2] = this.currentSteps;
		return saida;

	}

	public String getCurrentState() {
		return this.currentState;
	}

	public String getCurrentTape() {
		return this.currentTape;
	}

	public String getCurrentSteps() {
		return this.currentSteps;
	}	
	
	

}
