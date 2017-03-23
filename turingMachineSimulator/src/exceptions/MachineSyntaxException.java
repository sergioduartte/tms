package exceptions;

public class MachineSyntaxException extends Exception {

	public MachineSyntaxException(String message, int line) {
		super(message + ". At line: "+ (line - 1));
	}

}
