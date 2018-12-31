package com.wisilica.wiseconnect.service;

import org.springframework.stereotype.Service;

import com.wisilica.wiseconnect.model.OperateRequest;
import com.wisilica.wiseconnect.model.OperateResponse;

@Service
public interface OperateService {

	OperateResponse operate(OperateRequest operateRequest);

}
