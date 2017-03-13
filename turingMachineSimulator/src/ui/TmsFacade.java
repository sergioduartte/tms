package ui;

import java.util.Scanner;

import turingMachineSimulator.machine.FactoryMachine;
import turingMachineSimulator.machine.Machine;

public class TmsFacade {
	
	private static Machine machine;
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		printHeader();
		
		
		String opt = sc.nextLine();
		while(true){
			if (opt.toLowerCase().equals("s")) {
				startMachine(sc);
			}
		}
		
		
		
	}


	private static void startMachine(Scanner sc) {
		machine = FactoryMachine();
		
	}


	private static void printHeader() {
		System.out.println(">>>>> Welcome to Turing Machine Simulator <<<<<\n");
		System.out.println(">>> Please follow the form(separated by spaces):");
		System.out.println("<current state> <current symbol> <new symbol> <direction> <new state>\n");
		System.out.println(">>> Using the syntax:");
		System.out.println("> q0, q1,..., qn, qA, qR for the states where\n  q0,qA and qR are initial state, acceptance state and rejected state");
		System.out.println("> any character for <current symbol> and <new symbol> or '-'(hifen) to represent blank symbol");
		System.out.println("> the <direction> should be 'l' to 'move left or 'r' to move right, '*' represents 'do not move'");
		System.out.print(">>> Press S to start write your machine or E to exit");
	}
}
