package com.xworkz.Iapp.restcontroller;

import com.xworkz.Iapp.dto.ValidationResponseDTO;
import com.xworkz.Iapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class UserRestController {

    @Autowired
    private UserService userService;


    @GetMapping("/checkEmailAndTries")
    public ValidationResponseDTO checkEmail(@RequestParam(name = "email") String email) {
        ValidationResponseDTO validationResponseDTO=userService.emailExists(email);
        System.out.println(validationResponseDTO);
        return validationResponseDTO;
    }


    @GetMapping("/checkPhoneNoExists")
    public ResponseEntity<String> checkPhoneNo(@RequestParam(name = "phoneNo") String phoneNo) {
        Boolean exists = userService.phoneNoExists(phoneNo);
        return ResponseEntity.ok(exists.toString());
    }




}
