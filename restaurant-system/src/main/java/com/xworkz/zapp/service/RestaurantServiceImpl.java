package com.xworkz.zapp.service;

import com.xworkz.zapp.dto.RestaurantDTO;
import com.xworkz.zapp.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class RestaurantServiceImpl implements RestaurantService{

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Override
    public boolean validateAndSave(RestaurantDTO restaurantDTO) {
        boolean isValid=false;

        if(restaurantDTO.getName()==null || restaurantDTO.getName().length()<3){
            System.err.println("Entered  name is invalid");
            return isValid;
        }
        else if (restaurantDTO.getOwner()==null || restaurantDTO.getOwner().isEmpty()) {
            System.err.println("Entered owner is invalid");
            return isValid;
        }
        else if (restaurantDTO.getAddress()==null || restaurantDTO.getAddress().isEmpty()) {
            System.err.println("Entered address is invalid");
            return isValid;
        }
        else if (restaurantDTO.getType()==null || restaurantDTO.getType().length()<3) {
            System.err.println("Entered type is invalid");
            return isValid;
        }
        else if (restaurantDTO.getContactEmail()==null || restaurantDTO.getContactEmail().length()<8) {
            System.err.println("Entered email is invalid");
            return isValid;
        }
        else if (restaurantDTO.getContactNumber()<=0) {
            System.err.println("Entered contact number is invalid");
            return isValid;

        } else if (restaurantDTO.getRating()<=0) {
            System.err.println("Entered rating is invalid");
            return isValid;

        }
        else if (restaurantDTO.getOpeningTime()==null ||restaurantDTO.getOpeningTime().isEmpty()) {
            System.err.println("Entered opening time is invalid");
            return isValid;
        }

        else if (restaurantDTO.getClosingTime()==null ||restaurantDTO.getClosingTime().isEmpty()) {
            System.err.println("Entered closing time is invalid");
            return isValid;
        }
        else if (restaurantDTO.getEstablishedYear()==null ||restaurantDTO.getEstablishedYear().isEmpty()) {
                System.err.println("Entered established year is invalid");
                return isValid;

        } else {
            System.out.println("All data is valid");
            isValid=true;

            boolean isSaved=restaurantRepository.save(restaurantDTO);
            if(isSaved) System.out.println("Data saved successfully");
            else System.err.println("Failed to save data");
        }

        return isValid;
    }

    @Override
    public Optional<RestaurantDTO> validateAndSearchByName(String name) {
        if(name!=null || name.length()>3){
            Optional<RestaurantDTO> restaurantDTO=restaurantRepository.searchByName(name);
            return restaurantDTO;
        }
        return Optional.empty();
    }

}
