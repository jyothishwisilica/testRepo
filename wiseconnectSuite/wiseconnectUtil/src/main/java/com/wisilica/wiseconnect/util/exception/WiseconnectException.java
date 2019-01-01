package com.wisilica.wiseconnect.util.exception;

public class WiseconnectException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private String message;

	public WiseconnectException() {
		super();
	}

	public WiseconnectException(String message) {
		super(message);
		this.message = message;
	}

	public WiseconnectException(String message, Throwable cause) {
		super(message, cause);
		this.message = message;
	}

	public WiseconnectException(Throwable cause) {
		super(cause);
	}

	protected WiseconnectException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		this.message = message;
	}

	@Override
	public String toString() {
		return message;
	}

	@Override
	public String getMessage() {
		return message;
	}

}
