package com.wisilica.wiseconnect1.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wisilica.wiseconnect1.model.OperateRequest;
import com.wisilica.wiseconnect1.model.OperateResponse;
import com.wisilica.wiseconnect1.service.OperateService;

@Controller
public class DeviceOperateController {

	private static final Logger logger = LoggerFactory.getLogger(DeviceOperateController.class);

	@Autowired
	private OperateService operateService;

	@PostMapping("/public/operate")
	@ResponseBody
	public OperateResponse operate(OperateRequest operateRequest, HttpServletRequest request) {
		//logger.info("Request received: " + operateRequest);

		// TODO: operateRequest validation. If it is not valid return error response

		OperateResponse response = operateService.operate(operateRequest);		
		return response;
	}
}
