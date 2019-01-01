package com.wisilica.wiseconnect.util.exception;

import com.wisilica.wiseconnect.util.type.ErrorCode;

public class ServiceException extends WiseconnectException {

	private static final long serialVersionUID = 1L;

	private String message;

	private ErrorCode errorCode;

	public ServiceException() {
		super();
	}

	public ServiceException(ErrorCode errorCode, String message) {
		super(message);
		this.message = message;
		this.errorCode = errorCode;
	}

	public ServiceException(String message) {
		super(message);
		this.message = message;
	}

	public ServiceException(String message, Throwable cause) {
		super(message, cause);
		this.message = message;
	}

	public ServiceException(ErrorCode errorCode, String message, Throwable cause) {
		super(message, cause);
		this.message = message;
		this.errorCode = errorCode;
	}

	public ServiceException(Throwable cause) {
		super(cause);
	}

	protected ServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		this.message = message;
	}

	protected ServiceException(ErrorCode errorCodeEnum, String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
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

	public ErrorCode getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(ErrorCode errorCode) {
		this.errorCode = errorCode;
	}
}
