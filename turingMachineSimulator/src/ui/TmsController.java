package ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import turingMachineSimulator.machine.FactoryMachine;
import turingMachineSimulator.machine.Machine;

public class TmsController {
	private List<String> commandLines;
	private Machine machine;
	private List<String> tape;
	private int positionOnTape;
	private FactoryMachine factoryMachine;

	public TmsController() {
		this.commandLines = new ArrayList<String>();
		this.factoryMachine = new FactoryMachine();
	}

	public void mountMachine(Scanner userInput) {

		readCommands(userInput);
		machine = factoryMachine.FactoryMachine(commandLines);

	}

	public void readCommands(Scanner userInput) {

		String input = userInput.nextLine();

		while (true) {
			if (input.equals("end")) {
				break;
			}
			commandLines.add(input);
			input = userInput.nextLine();
		}

	}

	public void runMachine() {
		// TODO

	}

}