package com.xworkz.redcrossapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;
import java.util.Properties;

@Component
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.xworkz.redcrossapp")
public class RedCrossBloodConfiguration {

    public RedCrossBloodConfiguration(){
        System.out.println("RedCrossBloodConfiguration instance created");

    }

    @Bean
    public ViewResolver viewResolver(){
        InternalResourceViewResolver viewResolver=new InternalResourceViewResolver();
        viewResolver.setPrefix("/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }



    @Bean
    public DataSource getDataSource(){
        DriverManagerDataSource driverManagerDataSource=new DriverManagerDataSource();

        driverManagerDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/blood_donation");
        driverManagerDataSource.setUsername("root");
        driverManagerDataSource.setPassword("Root@123");

        return driverManagerDataSource;
    }

    @Bean
    public Properties getJpaProperties(){
        Properties properties=new Properties();

        properties.setProperty("hibernate.dialect","org.hibernate.dialect.MySQL8Dialect");

        return  properties;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean getEntityManagerFactory(){
        LocalContainerEntityManagerFactoryBean factoryBean=new LocalContainerEntityManagerFactoryBean();

        factoryBean.setDataSource(getDataSource());
        factoryBean.setPackagesToScan("com.xworkz.redcrossapp.entity");
        factoryBean.setJpaProperties(getJpaProperties());
        factoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());

        return factoryBean;
    }
}
