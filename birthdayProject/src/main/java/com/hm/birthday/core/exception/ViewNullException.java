package com.hm.birthday.core.exception;

public class ViewNullException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ViewNullException() {
		super();
	}

	public ViewNullException(String message, Throwable cause) {
		super(message, cause);
	}

	public ViewNullException(String message) {
		super(message);
	}

}
