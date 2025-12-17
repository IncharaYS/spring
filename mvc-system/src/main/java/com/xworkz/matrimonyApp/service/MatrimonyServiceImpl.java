package com.xworkz.matrimonyApp.service;

import com.xworkz.matrimonyApp.dto.MatrimonyDTO;
import com.xworkz.matrimonyApp.repository.MatrimonyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MatrimonyServiceImpl implements MatrimonyService {

    @Autowired
    private MatrimonyRepository matrimonyRepository;

    @Override
    public boolean validateAndSave(MatrimonyDTO matrimonyDTO) {

        boolean isInvalid = false;
        if (matrimonyDTO != null) {
            if (matrimonyDTO.getEmail() == null || matrimonyDTO.getEmail().length() < 6) {
                System.err.println("Invalid email entered");
                isInvalid = true;
            } else if (matrimonyDTO.getCreateProfileFor() == null || matrimonyDTO.getCreateProfileFor().length() < 2) {
                System.err.println("Invalid for entered");
                isInvalid = true;
            } else if (matrimonyDTO.getGender() == null || matrimonyDTO.getGender().length() < 4) {
                System.err.println("Invalid gender entered");
                isInvalid = true;
            } else if (matrimonyDTO.getDateOfBirth() == null || matrimonyDTO.getDateOfBirth().length() < 7) {
                System.err.println("Invalid date of birth entered");
                isInvalid = true;
            } else if (matrimonyDTO.getMotherTongue() == null || matrimonyDTO.getMotherTongue().length() < 3) {
                System.err.println("Invalid mother tongue entered");
                isInvalid = true;
            } else if (matrimonyDTO.getReligion() == null || matrimonyDTO.getReligion().length() < 4) {
                System.err.println("Invalid religion entered");
                isInvalid = true;
            } else if (matrimonyDTO.getMaritalStatus() == null || matrimonyDTO.getMaritalStatus().length() < 4) {
                System.err.println("Invalid marital status entered");
                isInvalid = true;
            } else if (matrimonyDTO.getHeight() < 2 && matrimonyDTO.getHeight() > 7) {
                System.err.println("Invalid height entered");
                isInvalid = true;
            } else {
                System.out.println("All data is valid");
            }
        }


        boolean isSaved=matrimonyRepository.save(matrimonyDTO);
        if(isSaved) System.out.println("Data saved successfully");
        else System.err.println("Failed to save data");


        return !isInvalid;
    }
}
