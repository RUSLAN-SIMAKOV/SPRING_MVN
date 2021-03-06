package spring_mvn.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import spring_mvn.model.User;

@Configuration
@ComponentScan(basePackages = { "spring_mvn.service", "spring_mvn.dao" })
public class AppConfig {

	@Bean
	public DataSource getDataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost/springdb?serverTimezone=EET");
		dataSource.setUsername("root");
		dataSource.setPassword("1");
		return dataSource;
	}

	@Bean
	public LocalSessionFactoryBean getSessionFactory() {
		LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
		localSessionFactoryBean.setDataSource(getDataSource());

		Properties properties = new Properties();
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.hbm2ddl.auto", "create-drop");

		localSessionFactoryBean.setHibernateProperties(properties);
		localSessionFactoryBean.setAnnotatedClasses(User.class);
		return localSessionFactoryBean;
	}
}
