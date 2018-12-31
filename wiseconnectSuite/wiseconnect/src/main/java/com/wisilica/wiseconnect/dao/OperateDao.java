package com.wisilica.wiseconnect.dao;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.wisilica.wiseconnect.model.entity.DeviceType;

@Repository
public interface OperateDao {
	
	void operateDevice();
	
	DeviceType save(DeviceType deviceType);
	
	Optional<DeviceType> findById(Long id);

}
