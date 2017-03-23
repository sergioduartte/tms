package ui;

import java.util.Scanner;

import exceptions.MachineSyntaxException;
import exceptions.MissingCommandException;
import exceptions.StateNotFoundException;
import turingMachineSimulator.machine.Machine;

public class TmsFacade {

	private Machine machine;
	private Scanner sc;
	private TmsController controller;

	public void start() {
		
		controller = new TmsController();
		machine = new Machine();
		sc = new Scanner(System.in);

		printHeader();

		String opt = sc.nextLine();

		if (opt.equalsIgnoreCase("s")) {
			mountMachine(sc); //le da entrada linha por linha os comandos monta a maquina baseada nos comandos
			runMachine(sc); // roda a MT pedindo entradas

		} else {
			System.out.println("Ending the application...");
			System.exit(0);
		}

	}

	private void mountMachine(Scanner userInput) {
		System.out.println("=========== When you end it, write 'end' and press enter button ==================\n");
		
		try {
			controller.mountMachine(userInput);
		} catch (MachineSyntaxException | StateNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void runMachine(Scanner userInput) {
		System.out.print("Now type the input word: ");
		try {
			controller.runMachine(userInput);
		} catch (MissingCommandException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void printHeader() {
		System.out.println(">>>>> Welcome to Turing Machine Simulator <<<<<\n");
		System.out.println(">>> Please follow the form(separated by spaces):");
		System.out.println("<current state> <current symbol> <new symbol> <direction> <new state>\n");
		System.out.println(">>> Using the syntax:");
		System.out.println(
				"> q0, q1,..., qn, qA, qR for the states where\n  q0,qA and qR are initial state, acceptance state and rejected state");
		System.out.println(
				"> any character for <current symbol> and <new symbol> or '-'(hifen) to represent blank symbol");
		System.out.println(
				"> the <direction> should be 'l' to 'move left or 'r' to move right, '*' represents 'do not move'\n");
		System.out.print(">>> Press 'S' to start write your commands, any other to quit the application: ");

	}

}
