package com.xworkz.travelAgencyApp.service;

import com.xworkz.travelAgencyApp.dto.UserDTO;
import com.xworkz.travelAgencyApp.repository.TravelAgencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TravelAgencyServiceImpl implements TravelAgencyService{

    @Autowired
    private TravelAgencyRepository travelAgencyRepository;

    @Override
    public boolean validateAndSave(UserDTO userDTO) {
        boolean isValid=true;
        if (userDTO.getFullName()==null || userDTO.getFullName().length()<3){
            isValid=false;
            System.err.println("Entered name is invalid");
            return isValid;
        } 
        else if (userDTO.getEmail()==null || userDTO.getEmail().length()<6) {
            isValid=false;
            System.err.println("Entered email is invalid");
            return isValid;
        }
        else if (userDTO.getPassword() == null || userDTO.getPassword().length()<8) {
            isValid=false;
            System.err.println("Entered email is invalid");
            return isValid;
        }
        else if (userDTO.getPhoneNo()<=0) {
            isValid=false;
            System.err.println("Entered phone number is invalid");
            return isValid;
        } else if (userDTO.getCountry()==null || userDTO.getCountry().length()<3) {
            isValid=false;
            System.err.println("Entered country is invalid");
            return isValid;
        }
        else {
            System.out.println("All data is valid");
    }

        boolean isSaved=travelAgencyRepository.save(userDTO);
        if(isSaved) System.out.println("Data saved successfully");
        else System.err.println("failed to save data");


        return  isValid;
    }
}
