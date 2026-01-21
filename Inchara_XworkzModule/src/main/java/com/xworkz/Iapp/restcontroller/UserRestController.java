package com.xworkz.Iapp.restcontroller;

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

    @GetMapping("/checkEmailExists")
    public ResponseEntity<String> checkEmail(@RequestParam(name = "email") String email) {
        Boolean exists = userService.emailExists(email);
        return ResponseEntity.ok(exists.toString());
    }


    @GetMapping("/checkPhoneNoExists")
    public ResponseEntity<String> checkPhoneNo(@RequestParam(name = "phoneNo") String phoneNo) {
        Boolean exists = userService.phoneNoExists(phoneNo);
        return ResponseEntity.ok(exists.toString());
    }
}
