package com.xworkz.travelAgencyApp.repository;

import com.xworkz.travelAgencyApp.dto.UserDTO;

public interface TravelAgencyRepository {
    boolean save(UserDTO userDTO);
}
