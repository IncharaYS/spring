package com.xworkz.Iapp.service;

import com.xworkz.Iapp.dto.UserDTO;
import com.xworkz.Iapp.entity.UserEntity;
import com.xworkz.Iapp.exceptions.DuplicateEmailException;
import com.xworkz.Iapp.exceptions.EmailNotRegisteredException;
import com.xworkz.Iapp.exceptions.InvalidPasswordException;
import com.xworkz.Iapp.repository.UserRepository;
import com.xworkz.Iapp.repository.UserRepositoryImpl;
import com.xworkz.Iapp.util.Encryption;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public boolean validateAndSave(UserDTO userDTO) {

        boolean isValidated = validateUserInfo(userDTO);
        boolean isSaved = false;

        if (!isValidated) {
            System.err.println("User data not validated");
            return false;
        }

        Optional<UserEntity> existingUser = userRepository.findByEmail(userDTO.getEmail());

        if (existingUser.isPresent()) {
            System.err.println("Email already exists: " + userDTO.getEmail());
            throw new DuplicateEmailException("Email already exists");
        }

        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(userDTO, userEntity);

        userEntity.setPassword(Encryption.encrypt(userDTO.getPassword()));


        try {
            isSaved = userRepository.save(userEntity);

            if (isSaved) {
                System.out.println("User saved successfully");
            } else {
                System.err.println("Failed to save user");
            }
        } catch (Exception e) {
            System.err.println("Exception while saving user: " + e.getMessage());
            isSaved = false;
        }

        return isSaved;
    }


    private boolean validateUserInfo(UserDTO userDTO) {

        if (userDTO.getUserName() == null || userDTO.getUserName().trim().isEmpty()) {
            System.err.println("Invalid user name");
            return false;
        }

        if (userDTO.getEmail() == null || userDTO.getEmail().trim().isEmpty()) {
            System.err.println("Invalid email");
            return false;
        }

        if (userDTO.getPhoneNo() <= 0) {
            System.err.println("Invalid phone number");
            return false;
        }

        if (userDTO.getAge() <= 0) {
            System.err.println("Invalid age");
            return false;
        }

        if (userDTO.getGender() == null || userDTO.getGender().trim().isEmpty()) {
            System.err.println("Invalid gender");
            return false;
        }

        if (userDTO.getAddress() == null || userDTO.getAddress().trim().isEmpty()) {
            System.err.println("Invalid address");
            return false;
        }

        if (userDTO.getPassword() == null || userDTO.getPassword().trim().isEmpty()) {
            System.err.println("Invalid password");
            return false;
        }

        if (!userDTO.getPassword().equals(userDTO.getConfirmPassword())) {
            System.err.println("Password and confirm password do not match");
            return false;
        }

        return true;
    }

    @Override
    public UserDTO validateLogin(UserDTO userDTO) {

        Optional<UserEntity> userOpt = userRepository.findByEmail(userDTO.getEmail());

        if (!userOpt.isPresent()) {
            throw new EmailNotRegisteredException("Email is not registered. Please register first.");
        }

        UserEntity entity = userOpt.get();

        String decryptedPassword = Encryption.decrypt(entity.getPassword());

        if (!decryptedPassword.equals(userDTO.getPassword())) {
            throw new InvalidPasswordException("Incorrect password. Please try again.");
        }
        UserDTO dto = new UserDTO();
        BeanUtils.copyProperties(entity, dto);



        return dto;
    }




}
