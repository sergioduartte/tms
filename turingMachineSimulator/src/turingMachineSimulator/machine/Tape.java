package turingMachineSimulator.machine;

import java.util.ArrayList;

public class Tape {
	
	private final String BLANK = "_";
	
	private ArrayList<String> input;
	private int position;
	
	public Tape() {
		this.position = 1;
		this.input = new ArrayList<String>();
	}
	
	public void insertOnTape(String input) {
		
		this.input.add(BLANK);
		for (String symbol : input.split("")) { //checar se o symbol é "_"
			this.input.add(symbol);
		}
		this.input.add(BLANK);
	}

	public String getPos() {
		return this.input.get(position);
	}
	
	public void move(String direction){
		if (direction.toLowerCase().equals("l")) {
			this.position--;
		} else if(direction.toLowerCase().equals("r")){
			this.position++;
		} else if(direction.toLowerCase().equals("*")){
			//ter certeza que nao anda na fita
		} else {	
			System.out.println("invalid direction... Please fix your commands and rerun the apllication"); //lancar excessao.
		}
	}

	public void write(String writeSymbol) {
		if (!writeSymbol.equals("*")) {
			input.set(position, writeSymbol); 
		}
		
	}

}
