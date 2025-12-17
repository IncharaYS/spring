package com.xworkz.medicalStoreApp;

import com.xworkz.medicalStoreApp.config.MedicalStoreConfigurations;
import com.xworkz.medicalStoreApp.dto.CustomerDTO;
import com.xworkz.medicalStoreApp.service.MedicalStoreService;
import com.xworkz.medicalStoreApp.service.MedicalStoreServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class MedicalStoreRunner {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
//        System.out.print("Enter customer id:");
//        int customerId=sc.nextInt();

        System.out.print("Enter customer full name:");
        String fullName=sc.next(); sc.nextLine();

        System.out.print("Enter customer email:");
        String email=sc.next();sc.nextLine();

        System.out.print("Enter password:");
        String password=sc.next();sc.nextLine();

        System.out.print("Enter customer phone number:");
        long phoneNo=sc.nextLong();sc.nextLine();

        System.out.print("Enter customer age:");
        int age=sc.nextInt();

        CustomerDTO customerDTO=new CustomerDTO(fullName,email,password,phoneNo,age);

        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(MedicalStoreConfigurations.class);
        MedicalStoreService medicalStoreService=applicationContext.getBean(MedicalStoreService.class);

        boolean success=medicalStoreService.validateAndSave(customerDTO);
        if(success) System.out.println("Data validated and saved successfully");
        else System.err.println("Failed to validate and save data");

    }
}
