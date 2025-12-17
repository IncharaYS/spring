package com.xworkz.travelAgencyApp;

import com.xworkz.travelAgencyApp.config.TravelAgencyConfigurations;
import com.xworkz.travelAgencyApp.dto.UserDTO;
import com.xworkz.travelAgencyApp.repository.TravelAgencyRepositoryImpl;
import com.xworkz.travelAgencyApp.service.TravelAgencyService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class travelAgencyRunner {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        System.out.print("Enter users full name:");
        String fullName=sc.nextLine();

        System.out.print("Enter users email:");
        String email=sc.nextLine();

        System.out.print("Enter password:");
        String password=sc.nextLine();

        System.out.print("Enter phone number:");
        long phoneNo=sc.nextLong();sc.nextLine();

        System.out.print("Enter users country:");
        String country=sc.nextLine();



        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(TravelAgencyConfigurations.class);

        UserDTO userDTO=new UserDTO(fullName,email,password,phoneNo,country,false);

        TravelAgencyService travelAgencyService=applicationContext.getBean(TravelAgencyService.class);

        boolean success=travelAgencyService.validateAndSave(userDTO);
        if(success) System.out.println("Successfully validated and saved");
        else System.err.println("Failed to validate and save");



    }
}
