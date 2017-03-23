package turingMachineSimulator.machine;

import java.util.List;

import exceptions.MachineSyntaxException;
import exceptions.StateNotFoundException;

public class FactoryMachine{

	// Estando em <Estado Atual>, lendo <Simbolo da entrada> eh escrito
	// <NovoSimbolo> e a cabeça eh movida para a <direcao> na fita indo para
	// <novo estado>

	public Machine FactoryMachine(List<String> commandLines) throws MachineSyntaxException, StateNotFoundException {
		
		Machine machine = new Machine();
		
		for (int line = 0; line < commandLines.size(); line++) {
			try {
				machine.addState(commandLines.get(line));
			} catch (Exception e) {
				throw new MachineSyntaxException(e.getMessage(), line);
			}
			

		}
		
		machine.organizeStates();

		return machine;

	}

}
