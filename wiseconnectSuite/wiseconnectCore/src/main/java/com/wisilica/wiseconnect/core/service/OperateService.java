package com.wisilica.wiseconnect.core.service;

import org.springframework.stereotype.Service;

import com.wisilica.wiseconnect.model.request.OperateRequest;
import com.wisilica.wiseconnect.model.response.OperateResponse;

@Service
public interface OperateService {

	OperateResponse operate(OperateRequest operateRequest);

}
