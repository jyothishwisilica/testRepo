package com.wisilica.wiseconnect.type.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.bind.BindException;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.wisilica.wiseconnect.controller.exception.ControllerException;
import com.wisilica.wiseconnect.type.ResponseCode;
import com.wisilica.wiseconnect.util.exception.ServiceException;

public class WebUtil {

	private static final Logger LOGGER = LoggerFactory.getLogger(WebUtil.class);
	
	private WebUtil() {

	}
	
	public static ResponseCode getResponseCodeFromException(Exception ex) {
		ResponseCode responseCode = null;
		if (ex instanceof ServiceException) {
			ServiceException se = (ServiceException) ex;
			responseCode = ResponseCode.getByErrorCode(se.getErrorCode());
		}

		if (ex instanceof ControllerException) {
			ControllerException ce = (ControllerException) ex;
			responseCode = ce.getResponseCode();
		}

		if (ex instanceof MethodArgumentTypeMismatchException || ex instanceof BindException) {
			responseCode = ResponseCode.BAD_REQUEST;
		}
		if (responseCode == null) {
			responseCode = ResponseCode.INTERNAL_SERVER_ERROR;
		}
		return responseCode;
	}

}
