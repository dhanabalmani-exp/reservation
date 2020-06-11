/**
 * 
 */
package com.kyyba.reservation.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * @author DhanabalM
 *
 */
@SpringBootApplication(scanBasePackages = { "com.kyyba.reservation.rest", "com.kyyba.reservation.persistence" })
@EnableAspectJAutoProxy
@EnableAutoConfiguration(exclude = { //
		DataSourceAutoConfiguration.class, //
		DataSourceTransactionManagerAutoConfiguration.class, //
		HibernateJpaAutoConfiguration.class })
public class ReservationApp extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(ReservationApp.class);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(ReservationApp.class);
		app.run(args);
	}

	/** Spring Environment instance to get the configurations */
	@Autowired
	private Environment environment;

	/**
	 * Method to get the portal3 datasource created
	 * 
	 * @return the DataSource object
	 * 
	 * @throws Exception
	 */
	@Bean(name = "dataSource")
	public DataSource dataSource() throws Exception {

		final ComboPooledDataSource dataSource = new ComboPooledDataSource();
		dataSource.setDriverClass(environment.getRequiredProperty("jdbc.driverClassName"));
		dataSource.setJdbcUrl(environment.getRequiredProperty("jdbc.url"));
		dataSource.setUser(environment.getRequiredProperty("jdbc.username"));
		dataSource.setPassword(environment.getRequiredProperty("jdbc.password"));

		dataSource.setPreferredTestQuery(environment.getRequiredProperty("hibernate.c3p0.preferredTestQuery"));
		dataSource.setMinPoolSize(Integer.parseInt(environment.getRequiredProperty("hibernate.c3p0.min_size")));
		dataSource.setMaxPoolSize(Integer.parseInt(environment.getRequiredProperty("hibernate.c3p0.max_size")));
		dataSource.setCheckoutTimeout(
				Integer.parseInt(environment.getRequiredProperty("hibernate.c3p0.checkoutTimeout")));
		return dataSource;
	}

	/**
	 * Method to get the hibernate session factory using datasource.
	 * 
	 * @param dataSource
	 *            DataSource object
	 * @return the LocalSessionFactoryBean object
	 */
	@Bean(name = "sessionFactory")
	@Autowired
	public LocalSessionFactoryBean sessionFactory(@Qualifier("dataSource") final DataSource dataSource) {
		final LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource);
		sessionFactory.setPackagesToScan(new String[] { "" });
		sessionFactory.setAnnotatedPackages(new String[] { "" });
		sessionFactory.setHibernateProperties(hibernateProperties());

		return sessionFactory;
	}

	/**
	 * Method to get hibernate properties from configuration file.
	 * 
	 * @return the Properties object
	 */
	private Properties hibernateProperties() {
		final Properties properties = new Properties();
		properties.put("hibernate.dialect", environment.getRequiredProperty("hibernate.dialect"));
		properties.put("hibernate.show_sql", environment.getRequiredProperty("hibernate.show_sql"));
		properties.put("hibernate.format_sql", environment.getRequiredProperty("hibernate.format_sql"));

		return properties;
	}

	/**
	 * Method to get hibernate template using session factory.
	 * 
	 * @param sessionFactory
	 *            SessionFactory object
	 * @return the HibernateTemplate object
	 */
	@Bean(name = "hibernateTemplate")
	@Autowired
	public HibernateTemplate hibernateTemplate(@Qualifier("sessionFactory") final SessionFactory sessionFactory) {
		final HibernateTemplate hibernateTemplate = new HibernateTemplate(sessionFactory);

		return hibernateTemplate;
	}

	/**
	 * Method to get hibernate transaction manager using session factory.
	 * 
	 * @param sessionFactory
	 *            SessionFactory object
	 * @return the HibernateTransactionManager object
	 */
	@Bean(name = "transactionManager")
	@Autowired
	public HibernateTransactionManager transactionManager(
			@Qualifier("sessionFactory") final SessionFactory sessionFactory) {
		final HibernateTransactionManager txManager = new HibernateTransactionManager(sessionFactory);

		return txManager;
	}

}
