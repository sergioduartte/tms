package turingMachineSimulator.machine;

import java.util.ArrayList;
import java.util.HashMap;

public class Transition {
	
	private HashMap<String, ArrayList<String>> transition;
	
	public Transition(String inputSymbol, String writeSymbol, String directionSymbol) {
		//to com muito sono, vai na gambs depois resolvo çapora
		this.transition = new HashMap<String, ArrayList<String>>() ;
		ArrayList<String> temp = new ArrayList<String>();
		temp.add(writeSymbol);
		temp.add(directionSymbol);
		transition.put(inputSymbol, temp);
		
	}

	
	

	//saida no formato ['simboloLido','simboloAescrever', 'direcaoDaCabeca']
	public ArrayList<String> getResult(){
		ArrayList<String> saida = new ArrayList<String>();
		saida.add(transition.keySet().toString());
		for (String string : transition.get()) {
			
		}
	}
	
	

}
