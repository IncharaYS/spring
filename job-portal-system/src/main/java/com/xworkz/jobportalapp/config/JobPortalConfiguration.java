package com.xworkz.jobportalapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


@Component
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.xworkz.jobportalapp")
public class JobPortalConfiguration implements WebMvcConfigurer{

        @Bean
        public ViewResolver viewResolver(){
            InternalResourceViewResolver viewResolver=new InternalResourceViewResolver();
            viewResolver.setPrefix("/");
            viewResolver.setSuffix(".jsp");
            return viewResolver;
        }

        @Override
        public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
            configurer.enable();
        }
    }
