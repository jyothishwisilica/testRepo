package com.wisilica.wiseconnect.controller.device;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wisilica.wiseconnect.core.service.OperateService;
import com.wisilica.wiseconnect.model.request.OperateRequest;
import com.wisilica.wiseconnect.model.response.OperateResponse;

@Controller
public class DeviceOperateController {

	private static final Logger LOGGER = LoggerFactory.getLogger(DeviceOperateController.class);

	@Autowired
	private OperateService operateService;

	@PostMapping("/public/operate")
	@ResponseBody
	public OperateResponse operate(OperateRequest operateRequest, HttpServletRequest request) {
		LOGGER.info("Request received: " + operateRequest);

		// TODO: operateRequest validation. If it is not valid return error response

		OperateResponse response = operateService.operate(operateRequest);		
		LOGGER.info("Request Processed: " + response);
		return response;
	}
}
