package com.xworkz.zapp.service;

import com.xworkz.zapp.dto.RestaurantDTO;

import java.util.Optional;

public interface RestaurantService {
    boolean validateAndSave(RestaurantDTO restaurantDTO);

    Optional<RestaurantDTO> validateAndSearchByName(String name);
}
