package com.wisilica.wiseconnect.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.wisilica.wiseconnect.model.entity.DeviceType;

@Repository
public interface DeviceTypeRepository extends JpaRepository<DeviceType, Long> {

	@Procedure(procedureName = "add_device_type")
	boolean addDeviceByProc(@Param("_device_type") Integer type, @Param("_description") String description,
			@Param("_major") Integer major, @Param("_minor") Integer minor, @Param("_user_type") Integer userType,
			@Param("_device_name") String name);

}
