package com.wisilica.wiseconnect.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.wisilica.wiseconnect.type.ResponseCode;
import com.wisilica.wiseconnect.type.util.WebUtil;

@ControllerAdvice
public class ExceptionHandlerAdvice {

	private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionHandlerAdvice.class);

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handleException(HttpServletRequest request, HttpServletResponse response,
			Exception ex) {
		LOGGER.error("Exception occured while executing {}", request.getRequestURI(), ex);
		ResponseCode responseCode = WebUtil.getResponseCodeFromException(ex);
		return new ResponseEntity<>(responseCode.getMessage(), responseCode.getHttpStatus());
	}
}
