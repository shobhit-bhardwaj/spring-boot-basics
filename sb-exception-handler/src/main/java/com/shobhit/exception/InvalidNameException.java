package com.shobhit.exception;

public class InvalidNameException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public InvalidNameException() {
		super();
	}

	public InvalidNameException(String message) {
		super(message);
	}
}