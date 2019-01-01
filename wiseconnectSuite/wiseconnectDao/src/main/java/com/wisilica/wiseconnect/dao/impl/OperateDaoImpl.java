package com.wisilica.wiseconnect.dao.impl;

import java.util.Optional;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.wisilica.wiseconnect.dao.OperateDao;
import com.wisilica.wiseconnect.dao.repository.DeviceTypeRepository;
import com.wisilica.wiseconnect.model.entity.DeviceType;

@Repository
public class OperateDaoImpl implements OperateDao {

	private static final Logger LOGGER = LoggerFactory.getLogger(OperateDaoImpl.class);
	
	@Autowired
	private DeviceTypeRepository deviceTypeRepository;

	@Qualifier("masterDataSource")
	@Autowired
	private DataSource masterDataSource;

	@Qualifier("readerDataSource")
	@Autowired
	private DataSource readerDataSource;

	@Qualifier("readerWiseDataSource")
	@Autowired
	private DataSource readerWiseDataSource;	
	
    @Qualifier("masterJdbcTemplate")
    @Autowired
    private JdbcTemplate masterJdbcTemplate;
	
	private static int counter = 1;

	public void operateDevice() {
		counter++;
		masterJdbcTemplate.update("call add_device_type(?,?,?,?,?,?)", counter, "Test" + counter, counter, 0, 7, "Test D");
	}
	
	public DeviceType save(DeviceType deviceType) {
		return deviceTypeRepository.save(deviceType);
	}

	public Optional<DeviceType> findById(Long id) {
		return deviceTypeRepository.findById(id);
	}

	@Override
	public void addDeviceByProc(Integer type, String description, Integer major, Integer minor, Integer userType,
			String name) {
		deviceTypeRepository.addDeviceByProc(type, description, major, minor, userType, name);		
	}	
}
