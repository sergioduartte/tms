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
	}

	public void readCommands(Scanner sc) {
		System.out.println("=========== When you end it, write 'end' and press enter button ==================");
		
		String input = sc.nextLine();
		
		while (input != "end") {
			commandLines.add(input);
		}
	}

	public void mountMachine() {
		machine  = factoryMachine.FactoryMachine(commandLines);
		
	}

}
