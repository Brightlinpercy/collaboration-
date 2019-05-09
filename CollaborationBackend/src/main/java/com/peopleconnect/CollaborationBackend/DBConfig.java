package com.peopleconnect.CollaborationBackend;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
@Configuration
@EnableTransactionManagement
@ComponentScan("com.peopleconnect")

public class DBConfig {
	
	@Bean
	DataSource myDataSource()
	{	
		BasicDataSource basicDataSource=new BasicDataSource();
		basicDataSource.setDriverClassName("org.h2.Driver");
		basicDataSource.setUrl("jdbc:h2:tcp://localhost/~/peopleconnectnew");
		basicDataSource.setUsername("sa");
		basicDataSource.setPassword("sa");
		return basicDataSource;
	}
	
	Properties myProperties()
	{
		Properties properties=new Properties();
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		properties.setProperty("hibernate.show_sql", "true");
		properties.setProperty("hibernate.hbm2ddl.auto", "update");
		return properties;
	}
	@Bean("sesssionFactory")
	LocalSessionFactoryBean localSessionFactoryBean()
	{
		LocalSessionFactoryBean  localSessionFactoryBean=new LocalSessionFactoryBean();
		localSessionFactoryBean.setDataSource(myDataSource());
		localSessionFactoryBean.setHibernateProperties(myProperties());
		localSessionFactoryBean.setPackagesToScan("com.peopleconnect.CollaborationBackend.model");
		return localSessionFactoryBean;
	}
	
	@Bean
	@Autowired
	
	HibernateTransactionManager hibernateTransactionManager(SessionFactory sessionFactory)
	{
		HibernateTransactionManager htm=new HibernateTransactionManager();
		htm.setSessionFactory(sessionFactory);
		return htm;
	}


}