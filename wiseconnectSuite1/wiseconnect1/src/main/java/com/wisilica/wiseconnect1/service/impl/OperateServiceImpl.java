package com.wisilica.wiseconnect1.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wisilica.wiseconnect1.dao.OperateDao;
import com.wisilica.wiseconnect1.model.Data;
import com.wisilica.wiseconnect1.model.OperateRequest;
import com.wisilica.wiseconnect1.model.OperateResponse;
import com.wisilica.wiseconnect1.model.Status;
import com.wisilica.wiseconnect1.service.MessageService;
import com.wisilica.wiseconnect1.service.OperateService;

@Service
public class OperateServiceImpl implements OperateService {

	@Autowired
	private OperateDao operateDao;
	
	@Autowired
	private MessageService messageService;
	
	@Override
	@Transactional
	public OperateResponse operate(OperateRequest operateRequest) {
		
		messageService.publish("Hello Wisilica", "Channel1");	

		OperateResponse response = new OperateResponse();
		Status status = new Status();
		Data data = new Data();
		response.setStatus(status);
		response.setData(data);
		status.setApiId("123");
		status.setEndTime("1490279492.0119");
		status.setStartTime("1490279490.261");
		status.setStatusCode("20001");
		status.setVersion("2.6.3.0");
		status.setStatusMessage("Operation logged");
		data.setOperateLogId("1");
		data.setTotalExecTime("1.7508549690247");
		data.setOperateLogId("1");
		
		operateDao.operateDevice();

		return response;
	}
}
