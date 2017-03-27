package ui;

import java.util.Scanner;

public class TmsFacade {

	private Scanner sc;
	private TmsController controller;

	public void start() {
		
		controller = new TmsController();
		sc = new Scanner(System.in);

		printHeader();

		String opt = sc.nextLine();

		if (opt.equalsIgnoreCase("s")) {
			//le da entrada linha por linha os comandos monta a maquina baseada nos comandos
			mountMachine(sc); 
			// roda a MT pedindo entradas
			runMachine(sc); 

		} else {
			System.out.println("Ending the application...");
			System.exit(0);
		}

	}
	
	// vai tentar montar a maquina, caso nao seja possivel, mostra o erro na tela e fecha a aplicacao
	private void mountMachine(Scanner userInput) {
		System.out.println("=========== When you end it, write 'end' and press enter button ==================\n");
		
		try {
			controller.mountMachine(userInput);
		} catch (Exception e) {
			printException(e);
		}
		
	}

	private void runMachine(Scanner userInput) {
		System.out.print("Now type the input word: \n>");
		try {
			controller.runMachine(userInput);
		} catch (Exception e) {
			printException(e);
		}
		
	}

	private void printHeader() {
		System.out.println(">>>>> Welcome to Turing Machine Simulator <<<<<\n");
		System.out.println(">>> Please follow the pattern(separated by spaces):");
		System.out.println("<current state> <current symbol> <new symbol> <direction> <new state>\n");
		System.out.println(">>> Using the syntax:");
		System.out.println(
				"> '!!' for the comments\n>q0, q1,..., qn, qA, qR for the states where\n  q0,qA and qR are initial state, acceptance state and rejected state");
		System.out.println(
				"> any character for <current symbol> and <new symbol> or '-'(hifen) to represent blank symbol");
		System.out.println(
				"> the <direction> should be 'l' to 'move left or 'r' to move right, '*' represents 'do not move'\n");
		System.out.print(">>> Press 'S' to start write your commands, any other to quit the application: ");

	}
	
	private void printException(Exception e){
		System.out.println("Wasn't able to start the machine. Fix the problems and rerun the application. " + e.getMessage());
		e.printStackTrace();
		System.exit(0);
	}

}
