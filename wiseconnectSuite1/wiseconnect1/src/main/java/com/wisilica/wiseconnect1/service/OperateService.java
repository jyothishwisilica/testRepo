package com.wisilica.wiseconnect1.service;

import org.springframework.stereotype.Service;

import com.wisilica.wiseconnect1.model.OperateRequest;
import com.wisilica.wiseconnect1.model.OperateResponse;

@Service
public interface OperateService {

	OperateResponse operate(OperateRequest operateRequest);

}
