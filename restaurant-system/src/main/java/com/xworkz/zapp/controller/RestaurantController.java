package com.xworkz.zapp.controller;

import com.xworkz.zapp.dto.RestaurantDTO;
import com.xworkz.zapp.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;
import java.util.logging.Logger;

@Component
@RequestMapping("/")
public class RestaurantController {
    @Autowired
    private RestaurantService restaurantService;

    @PostMapping("/addrestaurant")
    public String addMedicine( RestaurantDTO restaurantDTO){

        boolean success=restaurantService.validateAndSave(restaurantDTO);

        if(success) {
            System.out.println("Validated and saved successfully");
            return "Search.jsp";
        }
        else System.err.println("Failed to save and validate data");
        return "FailurePage.jsp";

    }

    @GetMapping("/registerpage")
    public String register(){
        return "Register.jsp";
    }

    @GetMapping("/search")
    public String searchByName(@RequestParam("name") String name, Model model){

//
        Optional<RestaurantDTO> restaurantDTO =restaurantService.validateAndSearchByName(name);

        if (restaurantDTO.isPresent()){
            System.out.println("If present");
            System.out.println(restaurantDTO);
            model.addAttribute("restaurant",restaurantDTO.get());


        }
        else   model.addAttribute("restaurantNotFound","Entered restaurant name not found");

        return "Search.jsp";
    }

    @GetMapping("/searchPage")
    public String search(){
        return "Search.jsp";
    }
}
