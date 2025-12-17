package com.xworkz.matrimonyApp;

import com.xworkz.matrimonyApp.config.MatrimonyConfigurations;
import com.xworkz.matrimonyApp.dto.MatrimonyDTO;
import com.xworkz.matrimonyApp.service.MatrimonyService;
import com.xworkz.matrimonyApp.service.MatrimonyServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class MatrimonyRunner {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);

        System.out.print("Enter users email:");
        String email=sc.nextLine();

        System.out.print("Enter for Who the profile is created for:");
        String createProfileFor=sc.nextLine();

        System.out.print("Enter users gender:");
        String gender=sc.nextLine();

        System.out.print("Enter users date of birth:");
        String dateOfBirth=sc.nextLine();

        System.out.print("Enter users mother tongue:");
        String motherTongue=sc.nextLine();

        System.out.print("Enter users religion:");
        String religion=sc.nextLine();

        System.out.print("Enter users marital status:");
        String maritalStatus=sc.nextLine();

        System.out.print("Enter users height:");
        double height=sc.nextDouble();


        MatrimonyDTO matrimonyDTO=new MatrimonyDTO(email,createProfileFor,gender,dateOfBirth,motherTongue,religion,maritalStatus,height);

        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(MatrimonyConfigurations.class);
        MatrimonyService matrimonyService =applicationContext.getBean(MatrimonyServiceImpl.class);


        boolean success=matrimonyService.validateAndSave(matrimonyDTO );
        if(success) System.out.println("Validated and saved successfully");
        else System.err.println("Failed to validate and save");
    }
}
