package machine;

import java.util.List;

import exceptions.DirectionPatternException;
import exceptions.DuplicatedTransitionException;
import exceptions.MachineSyntaxException;
import exceptions.StateNotFoundException;
import exceptions.StatePatternException;

public class FactoryMachine{

	// Estando em <Estado Atual>, lendo <Simbolo da entrada> eh escrito
	// <NovoSimbolo> e a cabeça eh movida para a <direcao> na fita indo para
	// <novo estado>

	public static Machine getMachine(List<String> commandLines) throws MachineSyntaxException, StateNotFoundException {
		
		Machine machine = new Machine();
		
		for (int line = 0; line < commandLines.size(); line++) {
			try {
				if (!commandLines.get(line).startsWith("!!") ) {
					machine.addState(commandLines.get(line));
				}
				
			
			} catch (DuplicatedTransitionException | StatePatternException | DirectionPatternException e ) { 
				throw new MachineSyntaxException(e.getMessage(), line);
			}

		}
		try {
			machine.organizeStates();
		} catch (StateNotFoundException e) {
			throw e;
		}
		return machine;

	}

}
