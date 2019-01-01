package com.wisilica.wiseconnect.type;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;

import com.wisilica.wiseconnect.util.type.ErrorCode;

public enum ResponseCode {

	BAD_REQUEST(HttpStatus.BAD_REQUEST, "Bad Request"),
	INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error", ErrorCode.UN_EXPECTED_ERROR),
	UN_AUTHORIZED_ACCESS(HttpStatus.UNAUTHORIZED, "Un authorized access", ErrorCode.UN_AUTHORIZED_ACCESS);

	private static final Map<ErrorCode, ResponseCode> ERROR_CODE_RESPONSE_CODE_MAP = new HashMap<>();

	private final HttpStatus httpStatus;

	private final String message;

	private final ErrorCode errorCode;

	private static final ResponseCode[] values;

	static {
		values = values();
		for (ResponseCode res : values) {
			if (res.getErrorCode() != null) {
				ERROR_CODE_RESPONSE_CODE_MAP.put(res.getErrorCode(), res);
			}
		}
	}

	ResponseCode(HttpStatus httpStatus, String type, ErrorCode errorCode) {
		this.httpStatus = httpStatus;
		this.message = type;
		this.errorCode = errorCode;
	}

	ResponseCode(HttpStatus httpStatus, String type) {
		this.httpStatus = httpStatus;
		this.message = type;
		this.errorCode = null;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public String getMessage() {
		return message;
	}

	public ErrorCode getErrorCode() {
		return errorCode;
	}

	public static ResponseCode getByCode(HttpStatus httpStatus) {
		if (httpStatus == null) {
			return null;
		}
		for (ResponseCode responseCode : values) {
			if (responseCode.getHttpStatus().equals(httpStatus)) {
				return responseCode;
			}
		}
		return null;
	}

	public static ResponseCode getByErrorCode(ErrorCode errorCode) {
		if (errorCode == null) {
			return null;
		}
		return ERROR_CODE_RESPONSE_CODE_MAP.get(errorCode);
	}
}
