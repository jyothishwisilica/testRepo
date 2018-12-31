package com.wisilica.wiseconnect.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wisilica.wiseconnect.dao.OperateDao;
import com.wisilica.wiseconnect.model.Data;
import com.wisilica.wiseconnect.model.OperateRequest;
import com.wisilica.wiseconnect.model.OperateResponse;
import com.wisilica.wiseconnect.model.Status;
import com.wisilica.wiseconnect.model.entity.DeviceType;
import com.wisilica.wiseconnect.service.MessageService;
import com.wisilica.wiseconnect.service.OperateService;

@Service
public class OperateServiceImpl implements OperateService {
	
	private static final Logger logger = LoggerFactory.getLogger(OperateServiceImpl.class);
	
	@Autowired
	private MessageService messageService;
	
	@Autowired
	private OperateDao operateDao;
	
	private static int counter = 1;
	
	@Transactional
	@Override	
	public OperateResponse operate(OperateRequest operateRequest) {
		
		logger.info("Start of service class method");		
		
		counter++;
		
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
		
		//operateDao.addDeviceByProc(counter, "Test" + counter, counter, 0, 7, "Test D from Repo by Proc");
		
		DeviceType deviceType = new DeviceType();
		
		deviceType.setType(1);
		deviceType.setName("Test Repo");
		deviceType.setDescription("Desc Repo");
		deviceType.setMajor(2);
		deviceType.setMinor(3);
		
		operateDao.save(deviceType);
		
		DeviceType dt = operateDao.findById(deviceType.getId()).get();	
		
		logger.info("End of service class method");

		return response;
	}
}
