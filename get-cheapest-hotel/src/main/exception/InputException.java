package main.exception;

public class InputException extends Exception {

	
	public static final String INVALID_DATE_INPUT = "Invalid date Input";

	public InputException(String message) {
		super(message);
	}

}
