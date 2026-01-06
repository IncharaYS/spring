package com.xworkz.redcrossapp.service;

import com.xworkz.redcrossapp.dto.DonerDTO;
import com.xworkz.redcrossapp.dto.SearchDTO;
import com.xworkz.redcrossapp.repository.DonerAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

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
            isSaved = donerAccountRepository.save(donerDTO);

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

        if (donerDTO.getDonerEmail() == null ||
                !donerDTO.getDonerEmail().matches("^[A-Za-z0-9+_.-]+@(.+)$")) {

            System.err.println("Entered email is invalid");
            return isValid;
        }

        else if (donerDTO.getDonerBirthYear() <= 1900 ||
                donerDTO.getDonerBirthYear() > java.time.Year.now().getValue()) {

            System.err.println("Entered birth year is invalid");
            return isValid;
        }

        else if (donerDTO.getDonerBirthMonth() == null ||
                donerDTO.getDonerBirthMonth().length() < 3) {

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

        else if (donerDTO.getDonerLastName() == null ||
                donerDTO.getDonerLastName().length() < 2) {

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
    public Optional<DonerDTO> validateAndSearchByEmail(SearchDTO searchDTO) {
        if (searchDTO.getEmail() == null || searchDTO.getEmail().length() < 6) {
            System.err.println("Invalid email entered");
            return Optional.empty();
        }

        return donerAccountRepository.findByEmail(searchDTO);
    }


    @Override
    public DonerDTO updateDoner(DonerDTO donerDTO) {

        boolean isInvalid = false;

        if (donerDTO == null) {
            System.err.println("DTO is empty");
            return null;
        }

        isInvalid = validateFields(donerDTO);

        if (isInvalid) {
            System.err.println("Invalid doner data");
        }

        Optional<DonerDTO> updated = donerAccountRepository.update(donerDTO);

        if (updated.isPresent()) {
            System.out.println("Doner updated successfully");
            return updated.get();
        } else {
            System.err.println("Failed to update doner");
        }
            return null;
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
