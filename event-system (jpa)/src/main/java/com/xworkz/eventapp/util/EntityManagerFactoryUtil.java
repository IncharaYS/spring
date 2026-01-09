package com.xworkz.eventapp.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Data
@NoArgsConstructor
public class EntityManagerFactoryUtil {

   private static final EntityManagerFactory entityManagerFactory =  Persistence.createEntityManagerFactory("eventPU");

        public static EntityManagerFactory getEntityManagerFactory(){
            return  entityManagerFactory;
        }

        public static void close(){
            entityManagerFactory.close();
        }

}
