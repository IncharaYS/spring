package com.xworkz.zapp.repository;

import com.xworkz.zapp.dto.RestaurantDTO;

import java.util.Optional;

public interface RestaurantRepository {

    boolean save(RestaurantDTO restaurantDTO);
    Optional<RestaurantDTO> searchByName(String ownerName);
}
