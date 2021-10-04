package main;

public class NoHotelsAvailableException extends Exception {

	public static final String NO_HOTELS_AVAIALBE = "Sorry no hotels are availabe for the given date";

	public NoHotelsAvailableException(String message) {
		super(message);
	}
}
