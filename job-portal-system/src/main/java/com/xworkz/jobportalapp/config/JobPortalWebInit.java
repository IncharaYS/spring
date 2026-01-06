package com.xworkz.jobportalapp.config;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;


@Component
public class JobPortalWebInit extends AbstractAnnotationConfigDispatcherServletInitializer{


    @Override
        protected Class<?>[] getRootConfigClasses() {
            return new Class[0];
        }

        @Override
        protected Class<?>[] getServletConfigClasses() {
            return new Class[]{
                    JobPortalConfiguration.class
            };
        }

        @Override
        protected String[] getServletMappings() {
            return new String[]{"/"};
        }
    }

