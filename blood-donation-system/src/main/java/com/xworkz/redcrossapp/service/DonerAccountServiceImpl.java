package com.xworkz.redcrossapp.service;

import com.xworkz.redcrossapp.dto.DonerDTO;
import com.xworkz.redcrossapp.dto.SearchDTO;
import com.xworkz.redcrossapp.entity.DonerEntity;
import com.xworkz.redcrossapp.repository.DonerAccountRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

@Component
@Service
public class DonerAccountServiceImpl implements DonerAccountService{

    @Autowired
    private DonerAccountRepository donerAccountRepository;

    @Override
    public boolean validateAndSave(DonerDTO donerDTO) {

        boolean isValid = validateFields(donerDTO);
        boolean isSaved = false;

        if (isValid) {
            DonerEntity donerEntity=new DonerEntity();
            BeanUtils.copyProperties(donerDTO,donerEntity);
            isSaved = donerAccountRepository.save(donerEntity);

            if (isSaved)
                System.out.println("Successfully saved donor account data");
            else
                System.out.println("Failed to save donor account data");
        }
        else {
            System.out.println("Failed to validate donor account data");
        }

        return isSaved;
    }


    private static boolean validateFields(DonerDTO donerDTO) {

        boolean isValid = false;

        if (donerDTO.getDonerEmail() == null) {

            System.err.println("Entered email is invalid");
            return isValid;
        }

        else if (donerDTO.getDonerBirthYear() <= 1900 ) {

            System.err.println("Entered birth year is invalid");
            return isValid;
        }

        else if (donerDTO.getDonerBirthMonth() == null ) {

            System.err.println("Entered birth month is invalid");
            return isValid;
        }

        else if (donerDTO.getDonerBirthDay() <= 0 ||
                donerDTO.getDonerBirthDay() > 31) {

            System.err.println("Entered birth day is invalid");
            return isValid;
        }

        else if (donerDTO.getDonorId() != null &&
                donerDTO.getDonorId().length() < 2) {

            System.err.println("Entered donor ID is invalid");
            return isValid;
        }

        else if (donerDTO.getDonerFirstName() == null ||
                donerDTO.getDonerFirstName().length() < 2) {

            System.err.println("Entered first name is invalid");
            return isValid;
        }

        else if (donerDTO.getDonerLastName() == null ) {

            System.err.println("Entered last name is invalid");
            return isValid;
        }

        else if (donerDTO.getDonerZipCode() == null ||
                !donerDTO.getDonerZipCode().matches("\\d{5,6}")) {

            System.err.println("Entered ZIP code is invalid");
            return isValid;
        }

        else if (donerDTO.getDonerUsername() == null ||
                donerDTO.getDonerUsername().length() < 5) {

            System.err.println("Entered username is invalid");
            return isValid;
        }

        else if (donerDTO.getDonerPassword() == null ||
                donerDTO.getDonerPassword().length() < 8) {

            System.err.println("Entered password is invalid");
            return isValid;
        }

        else {
            System.out.println("All data is valid");
            isValid = true;
        }

        return isValid;
    }

    @Override
    public Optional<DonerDTO> validateAndSearchByEmail(String email) {

        if (email== null ||email.length() < 6) {
            System.err.println("Invalid email entered");
            return Optional.empty();
        }

        Optional<DonerEntity> donerEntity=donerAccountRepository.findByEmail(email);
        DonerDTO donerDTO=new DonerDTO();
        BeanUtils.copyProperties(donerEntity.get(),donerDTO);


        return Optional.of(donerDTO);
    }


    @Override
    public boolean updateDoner(DonerDTO donerDTO) {

        boolean isInvalid = false;

        if (donerDTO == null) {
            System.err.println("DTO is empty");
            return isInvalid;
        }

//        isInvalid = validateFields(donerDTO);
//
//        if (isInvalid) {
//            System.err.println("Invalid doner data");
//        }

        DonerEntity donerEntity=new DonerEntity();

        BeanUtils.copyProperties(donerDTO,donerEntity);

        boolean updated = donerAccountRepository.update(donerEntity);



        if (updated==true) {
            System.out.println("Doner updated successfully");
            return true;
        } else {
            System.err.println("Failed to update doner");
        }
            return false;
    }

    @Override
    public boolean deleteByEmail(String email) {

        if (email == null || email.length() < 6) {
            System.err.println("Invalid email for delete");
            return false;
        }

        boolean deleted = donerAccountRepository.deleteByEmail(email);

        if (deleted) {
            System.out.println("Doner deleted successfully");
            return true;
        } else {
            System.err.println("Delete failed or email not found");
            return false;
        }

    }
        @Override
        public boolean deleteById(int id) {

            if (id<0) {
                System.err.println("Invalid id for delete");
                return false;
            }

            boolean deleted = donerAccountRepository.deleteById(id);

            if (deleted) {
                System.out.println("Doner deleted successfully");
                return true;
            } else {
                System.err.println("Delete failed or email not found");
                return false;
            }
    }




}
