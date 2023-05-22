package com.capacitaciones.continuas.Configuration;


import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "mysqlEntityManagerFactory", transactionManagerRef = "mysqlPlatformTransactionManager",
        basePackages = { "com.capacitaciones.continuas.repositorys.Primarys"})
public class MySqlDataSourceConfig {

    @Autowired
    private Environment env;

    @Bean(name = "mysqlDataSource")
    public DataSource mysqlDatasource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(env.getProperty("mysql.datasource.url"));
        dataSource.setUsername(env.getProperty("mysql.datasource.username"));
        dataSource.setPassword(env.getProperty("mysql.datasource.password"));
        //dataSource.setDriverClassName(env.getProperty("mysql.datasource.driver-class-name"));

        return dataSource;
    }

    @Primary
    @Bean(name = "mysqlEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(mysqlDatasource());
        em.setPackagesToScan("com.capacitaciones.continuas.Modelos.Primary");

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);

        Map<String, Object> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto", env.getProperty("mysql.jpa.hibernate.ddl-auto"));
        properties.put("hibernate.show-sql", env.getProperty("mysql.jpa.show-sql"));
        properties.put("hibernate.dialect", env.getProperty("mysql.jpa.database-platform"));
        properties.put("hibernate.physical_naming_strategy", env.getProperty("mysql.jpa.properties.hibernate.physical_naming_strategy"));
        properties.put("hibernate.naming.physical-strategy", env.getProperty("mysql.jpa.properties.hibernate.naming.physical-strategy")); // corrección aquí
        em.setJpaPropertyMap(properties);

        return em;
    }

    @Primary
    @Bean(name = "mysqlPlatformTransactionManager")
    public PlatformTransactionManager platformTransactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
        return transactionManager;
    }

    @Bean(name = "mysqlJdbcTemplate")
    public JdbcTemplate userJdbcTemplate(@Qualifier("mysqlDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }



}