package ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import exceptions.DirectionPatternException;
import exceptions.DuplicatedTransitionException;
import exceptions.MachineSyntaxException;
import exceptions.MissingCommandException;
import exceptions.StateNotFoundException;
import exceptions.StatePatternException;
import machine.FactoryMachine;
import machine.Machine;

public class TmsController {
	private List<String> commandLines;
	private Machine machine;

	public TmsController() {
		this.commandLines = new ArrayList<String>();
	}

	public void mountMachine(Scanner userInput) throws MachineSyntaxException, StateNotFoundException, DuplicatedTransitionException{

		readCommands(userInput);
		machine = FactoryMachine.getMachine(commandLines);

	}

	public void readCommands(Scanner userInput) {
		int countLine = 1;
		System.out.print(countLine + ". ");
		String input = userInput.nextLine();
		countLine++;

		while (true) {
			if (input.equalsIgnoreCase("end")) {
				break;
			} else if (!input.startsWith("!!") || !input.startsWith("!! ")) { // comentarios
				commandLines.add(input);
			}
			// commandLines.add(input);
			System.out.print(countLine + ". ");
			input = userInput.nextLine();
			countLine++;
		}

	}

	public void runMachine(Scanner userInput) throws MissingCommandException {
		// recebe a palavra a ser processada
		String input = userInput.nextLine();

		// monta a fita com a palavra
		machine.insertOnTape(input);

		// roda a maquina com a palavra e retorna a string de QA ou QR
		String result = machine.run();

		// mostra os passos que a maquina deu para chegar ao resultado final
		machine.showSteps(userInput);

		// imprime se a palavra foi aceita ou nao.
		System.out.println(result);

	}

}
