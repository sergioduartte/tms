package machine;

public class Configuration {
	
	private String currentState;
	private String currentTape;
	private String currentSteps;
	
	public Configuration(String currentState, String currentTape, String currentSteps) {
		this.currentState = currentState;
		this.currentTape = currentTape;
		this.currentSteps = currentSteps;
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
