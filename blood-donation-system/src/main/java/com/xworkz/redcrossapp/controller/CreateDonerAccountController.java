package com.xworkz.redcrossapp.controller;

import com.xworkz.redcrossapp.dto.DonerDTO;
import com.xworkz.redcrossapp.dto.SearchDTO;
import com.xworkz.redcrossapp.service.DonerAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/")
public class CreateDonerAccountController {

    @Autowired
    private DonerAccountService service;

    public CreateDonerAccountController(){
        System.out.println("CreateDonerAccountController instance created");
    }

    @PostMapping("/addDoner")
    public String addDoner(@ModelAttribute DonerDTO dto, Model model){
        System.out.println("Received DTO: " + dto);

        boolean success = service.validateAndSave(dto);
        if(success){
            System.out.println("Data validated and saved successfully");
            model.addAttribute("successMsg","Data added successfully");
        } else {
            System.out.println("Failed to validate and save data");
        }

        return "Response";
    }


    @GetMapping("/search")
    public String search( SearchDTO searchDTO, Model model) {

        searchDTO.setEmail(searchDTO.getEmail());

        Optional<DonerDTO> result = service.validateAndSearchByEmail(searchDTO);

        if (result.isPresent()) {
            System.out.println("Successfully fetched data");
            model.addAttribute("donerInfo", result.get());
        } else {
            model.addAttribute("emailNotFound", "No user found with email: " + searchDTO.getEmail());
        }

        return "Search";
    }

    @GetMapping("searchNav")
    public  String searchNav(){
        return "Search";
    }

    @GetMapping("update")
    public String update(SearchDTO searchDTO,Model model){
        searchDTO.setEmail(searchDTO.getEmail());

        Optional<DonerDTO> result = service.validateAndSearchByEmail(searchDTO);

        if (result.isPresent()) {
            System.out.println("Successfully fetched data");
            model.addAttribute("donerInfo", result.get());
        } else {
            model.addAttribute("emailNotFound", "No user found with email: " + searchDTO.getEmail());
        }
        return "UpdateDoner";
    }

    @PostMapping("/updateDoner")
    public String updateDoner(DonerDTO donerDTO, Model model) {

            DonerDTO updatedDoner = service.updateDoner(donerDTO);
            if(updatedDoner!=null) {
                model.addAttribute("donerInfo", updatedDoner);
                model.addAttribute("updateSuccessMsg", "Doner updated successfully");
            }
            else {
                model.addAttribute("failedUpdate", "Update failed");
            }

        return "Search";
    }

    @GetMapping("/delete")
    public String deleteUser(SearchDTO searchDTO, Model model) {

        boolean isDeleted = service.deleteByEmail(searchDTO.getEmail());

        if (isDeleted) {
            model.addAttribute("updateSuccessMsg",
                    "Doner deleted successfully for email: " + searchDTO.getEmail());
        } else {
            model.addAttribute("failed",
                    "Failed to delete user with email: " + searchDTO.getEmail());
        }

        return "Search";
    }

}
