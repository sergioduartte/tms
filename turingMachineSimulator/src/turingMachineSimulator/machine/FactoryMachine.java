package turingMachineSimulator.machine;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FactoryMachine {

	private Machine machine;

	// Estando em <Estado Atual>, lendo <Simbolo da entrada> eh escrito
	// <NovoSimbolo> e a cabeça eh movida para a <direcao> na fita indo para
	// <novo estado>

	public Machine FactoryMachine(List<String> commandLines) {
		
		machine = new Machine();
		
		// para cada linha dos comandos
		for (int line = 0; line < commandLines.size(); line++) {

			machine.addState(commandLines.get(line));

		}
		
		machine.organizeStates();

		return machine;

	}

}
