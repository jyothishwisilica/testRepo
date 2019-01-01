package com.wisilica.wiseconnect.controller.exception;

import com.wisilica.wiseconnect.type.ResponseCode;
import com.wisilica.wiseconnect.util.exception.WiseconnectException;

public class ControllerException extends WiseconnectException {

	private static final long serialVersionUID = 1L;

	private String message;

	private ResponseCode responseCode;

	public ControllerException() {
		super();
	}

	public ControllerException(ResponseCode responseCode, String message) {
		super(message);
		this.message = message;
		this.responseCode = responseCode;
	}

	public ControllerException(String message) {
		super(message);
		this.message = message;
	}

	public ControllerException(String message, Throwable cause) {
		super(message, cause);
		this.message = message;
	}

	public ControllerException(ResponseCode responseCode, String message, Throwable cause) {
		super(message, cause);
		this.message = message;
		this.responseCode = responseCode;
	}

	public ControllerException(Throwable cause) {
		super(cause);
	}

	protected ControllerException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		this.message = message;
	}

	protected ControllerException(ResponseCode responseCode, String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		this.message = message;
		this.responseCode = responseCode;
	}

	@Override
	public String toString() {
		return message;
	}

	@Override
	public String getMessage() {
		return message;
	}

	public ResponseCode getResponseCode() {
		return responseCode;
	}

	public void setResponseCodeEnum(ResponseCode responseCode) {
		this.responseCode = responseCode;
	}
}
