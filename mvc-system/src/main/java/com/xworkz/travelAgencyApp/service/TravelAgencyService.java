package com.xworkz.travelAgencyApp.service;

import com.xworkz.travelAgencyApp.dto.UserDTO;

public interface TravelAgencyService {
    boolean validateAndSave(UserDTO userDTO);
}
