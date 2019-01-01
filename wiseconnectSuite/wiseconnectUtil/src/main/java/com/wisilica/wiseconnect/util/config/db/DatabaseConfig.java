package com.wisilica.wiseconnect.util.config.db;

import java.util.Properties;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

@Configuration
public class DatabaseConfig {
	
	private static final String PROPERTY_NAME_HIBERNATE_DIALECT = "hibernate.dialect";
	
    private static final String PROPERTY_NAME_HIBERNATE_FORMAT_SQL = "hibernate.format_sql";
    
    private static final String PROPERTY_NAME_HIBERNATE_SHOW_SQL = "hibernate.show_sql";
	
	@Resource
    private Environment environment;

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
	
	
	@Bean(name = "transactionManager")
    public JpaTransactionManager getTransactionManager() throws ClassNotFoundException {
        JpaTransactionManager transactionManager = new JpaTransactionManager();

        transactionManager.setEntityManagerFactory(getEntityManagerFactory().getObject());

        return transactionManager;
    }
    
    @Bean(name = "entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean getEntityManagerFactory() throws ClassNotFoundException {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();

        entityManagerFactoryBean.setDataSource(getMasterDataSource());
        entityManagerFactoryBean.setPackagesToScan("com.wisilica.wiseconnect.model.entity");
        entityManagerFactoryBean.setPersistenceProvider(new HibernatePersistenceProvider());

        Properties jpaProterties = new Properties();
        jpaProterties.put(PROPERTY_NAME_HIBERNATE_DIALECT, "org.hibernate.dialect.MySQLDialect");
        jpaProterties.put(PROPERTY_NAME_HIBERNATE_FORMAT_SQL, environment.getRequiredProperty(PROPERTY_NAME_HIBERNATE_FORMAT_SQL));        
        jpaProterties.put(PROPERTY_NAME_HIBERNATE_SHOW_SQL, environment.getRequiredProperty(PROPERTY_NAME_HIBERNATE_SHOW_SQL));

        entityManagerFactoryBean.setJpaProperties(jpaProterties);

        return entityManagerFactoryBean;
    }
}
