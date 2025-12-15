package com.xworkz.componentsapp.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.xworkz.componentsapp")
public class CoreConfigurations {

    public CoreConfigurations(){
        System.out.println("Configuration constructor invoked");
    }

}
