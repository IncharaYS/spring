package com.xworkz.formaapp.service;
import com.xworkz.formaapp.dto.UserDTO;

public interface UserService {

    boolean validateAndSave(UserDTO dto);
}

