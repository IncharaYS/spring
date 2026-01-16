package com.xworkz.Iapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@Component
@ComponentScan(basePackages = "com.xworkz.Iapp")
public class UserConfiguration {

    public UserConfiguration(){
        System.out.println("User configuration class initialized");
    }


    @Bean
    public ViewResolver ViewResolver(){
        InternalResourceViewResolver viewResolver=new InternalResourceViewResolver();
        viewResolver.setPrefix("/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    @Bean
    public DataSource getDataSource(){
        DriverManagerDataSource dataSource=new DriverManagerDataSource();

        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/modules");
        dataSource.setUsername("root");
        dataSource.setPassword("Root@123");


        return dataSource;
    }


    public Properties getJpaProperties(){
        Properties  properties=new Properties();
        properties.setProperty("hibernate.dialect","org.hibernate.dialect.MySQL8Dialect");
        properties.setProperty("hibernate.show_sql","true");
        properties.setProperty("hibernate.hbm2ddl.auto","update");
        return properties;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean getLocalContainerEntityManagerFactoryBean(){

        LocalContainerEntityManagerFactoryBean beanFactory=new LocalContainerEntityManagerFactoryBean();

        beanFactory.setDataSource(getDataSource());
        beanFactory.setPackagesToScan("com.xworkz.Iapp.entity");
        beanFactory.setJpaProperties(getJpaProperties());
        beanFactory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());

        return beanFactory;
    }
}
