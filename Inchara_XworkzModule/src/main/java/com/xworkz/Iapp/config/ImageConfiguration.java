package com.xworkz.Iapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@Configuration
public class ImageConfiguration {

    @Bean("multipartResolver")
    public CommonsMultipartResolver commonsMultipartResolver(){
        CommonsMultipartResolver commonsMultipartResolver=new CommonsMultipartResolver();
        commonsMultipartResolver.setMaxInMemorySize(104857);
        commonsMultipartResolver.setMaxUploadSize(104857);
        return commonsMultipartResolver;
    }
}
