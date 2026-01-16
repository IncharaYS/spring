package com.xworkz.Iapp.service;

import com.xworkz.Iapp.dto.UserDTO;
import com.xworkz.Iapp.exceptions.EmailNotRegisteredException;
import com.xworkz.Iapp.exceptions.InvalidPasswordException;

public interface UserService {

    boolean validateAndSave(UserDTO userDTO);

    UserDTO validateLogin(UserDTO userDTO) throws EmailNotRegisteredException, InvalidPasswordException;


}
