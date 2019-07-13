package com.paulocorreaslz.sisevent.data;


import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
@Profile("dev")
public class DataConfiguration {

	@Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("postgres://ozblfvgdwjscah:aa391a36fc7e4292f4c72c6a8422a2fde8df8e46dc0c50a5c791a43988284b19@ec2-174-129-227-51.compute-1.amazonaws.com:5432/d59df1kunfi28v");
        dataSource.setUsername("ozblfvgdwjscah");
        dataSource.setPassword("aa391a36fc7e4292f4c72c6a8422a2fde8df8e46dc0c50a5c791a43988284b19");
        return dataSource;
    }
	
	@Bean
	public JpaVendorAdapter jpaVendorAdapter(){
		HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
		adapter.setDatabase(Database.POSTGRESQL);
		adapter.setShowSql(true);
		adapter.setGenerateDdl(true);
		adapter.setDatabasePlatform("org.hibernate.dialect.PostgreSQLDialect");
		adapter.setPrepareConnection(true);
		return adapter;
	}
}
