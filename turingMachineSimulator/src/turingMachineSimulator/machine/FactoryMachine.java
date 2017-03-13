package turingMachineSimulator.machine;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FactoryMachine {
	
	private Machine machine;
	
	public Machine FactoryMachine(Scanner sc){
		String entrada = sc.next();
		
		while (entrada != "-1") {
			String[] linha = entrada.split(" ");
			if (!contemEstado(linha[0])) {
				
			}
		}
		
		return null;
	}
	
	//
	private boolean contemEstado(String estado) {
		for (int i = 0; i < machine.getFunctions.size(); i++) {
			if (linhas.get(i).get(0).equals(estado)) {
				return true;
			}
		}
		return false;
	}
	
	

}
