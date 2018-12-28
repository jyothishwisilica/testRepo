package com.wisilica.wiseconnect1.database;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class DatabaseConfig {

	@Bean(name = "masterDataSource")
	@ConfigurationProperties(prefix = "master.datasource")
	public DataSource getMasterDataSource() {
		return DataSourceBuilder.create().build();
	}
	
	@Bean(name = "readerDataSource")
	@ConfigurationProperties(prefix = "reader.datasource")
	public DataSource getReaderDataSource() {
		return DataSourceBuilder.create().build();
	}
	
	@Bean(name = "readerWiseDataSource")
	@ConfigurationProperties(prefix = "readerwise.datasource")
	public DataSource getReaderWiseDataSource() {
		return DataSourceBuilder.create().build();
	}
	
	@Bean(name = "masterJdbcTemplate")
	public JdbcTemplate getMasterJdbcTemplate(@Qualifier("masterDataSource") DataSource dataSource) {
	    return new JdbcTemplate(dataSource);
	}
	
	@Bean(name = "readerJdbcTemplate")
	public JdbcTemplate getReaderJdbcTemplate(@Qualifier("readerDataSource") DataSource dataSource) {
	    return new JdbcTemplate(dataSource);
	}
	
	@Bean(name = "readerWiseJdbcTemplate")
	public JdbcTemplate getReaderWiseJdbcTemplate(@Qualifier("readerWiseDataSource") DataSource dataSource) {
	    return new JdbcTemplate(dataSource);
	}
}
