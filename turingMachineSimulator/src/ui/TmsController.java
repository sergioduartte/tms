package ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import turingMachineSimulator.machine.FactoryMachine;
import turingMachineSimulator.machine.Machine;
import turingMachineSimulator.machine.Tape;

public class TmsController {
	private List<String> commandLines;
	private Machine machine;
	
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
			if (input.equalsIgnoreCase("end")) {
				break;
			}
			commandLines.add(input);
			input = userInput.nextLine();
		}

	}

	public void runMachine(Scanner userInput) {
		//recebe a palavra a ser processada
		String input = userInput.nextLine();
		//monta a fita com a palavra
		machine.insertOnTape(input);
		//roda a maquina com a palavra e retorna a string de QA ou QR
		String result = machine.run();
		//mostra os passos que a maquina deu para chegar ao resultado final
		machine.showSteps(userInput);
		//imprime se a palavra foi aceita ou nao.
		System.out.println(result);
		
	}

}
