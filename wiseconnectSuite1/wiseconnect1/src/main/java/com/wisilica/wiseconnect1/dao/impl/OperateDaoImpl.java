package com.wisilica.wiseconnect1.dao.impl;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.wisilica.wiseconnect1.dao.OperateDao;

@Repository
public class OperateDaoImpl implements OperateDao {

	private static final Logger logger = LoggerFactory.getLogger(OperateDaoImpl.class);

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
}
