package com.xworkz.Iapp.service;

import com.xworkz.Iapp.constants.IssueCode;
import com.xworkz.Iapp.dto.LoginDTO;
import com.xworkz.Iapp.dto.UserDTO;
import com.xworkz.Iapp.dto.ValidationResponseDTO;


import java.util.Optional;

public interface UserService {

    IssueCode validateAndSave(UserDTO userDTO);

    IssueCode validateLogin(LoginDTO loginDTO);

    Optional<UserDTO> findByEmail(String email);



    ValidationResponseDTO emailExists(String email);

    boolean phoneNoExists(String phoneNo);


    IssueCode verifyOtp(String email, String otp);

    IssueCode resetPassword(String email, String password);


    IssueCode updateUser(UserDTO userDTO);

    IssueCode deleteUser(String email);




}
