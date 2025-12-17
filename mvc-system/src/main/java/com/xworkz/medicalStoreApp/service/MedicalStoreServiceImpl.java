package com.xworkz.medicalStoreApp.service;

import com.xworkz.medicalStoreApp.dto.CustomerDTO;
import com.xworkz.medicalStoreApp.repository.MedicalStoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MedicalStoreServiceImpl implements MedicalStoreService {

    @Autowired
    private MedicalStoreRepository medicalStoreRepository;

    @Override
    public boolean validateAndSave(CustomerDTO customerDTO) {
        boolean isValid=true;
        if (customerDTO.getFullName()==null || customerDTO.getFullName().length()<3) {
            System.err.println("Customer name is invalid");
            isValid=false;
            return  isValid;

        } else if (customerDTO.getEmail()==null || customerDTO.getEmail().length()<6) {
            System.err.println("Customer email is invalid");
            isValid=false;
            return  isValid;

        } else if (customerDTO.getPassword()==null || customerDTO.getPassword().length()<8) {
            System.err.println("Customer password is invalid");
            isValid=false;
            return  isValid;

        } else if (customerDTO.getPhoneNo()<=0) {
            System.err.println("Customer phone number is invalid");
            isValid=false;
            return  isValid;

        }
        else if(customerDTO.getAge()<=0){
            System.err.println("Customer age is invalid");
            isValid=false;
            return  isValid;
        }
        else {
            System.out.println("All data is valid");
        }

        boolean isSaved=medicalStoreRepository.save(customerDTO);
        if (isSaved){
            System.out.println("Data saved successfully");
        }
        else System.out.println("Failed to save data");


        return isValid;
    }
}
