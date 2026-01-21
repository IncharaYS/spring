package com.xworkz.formaapp.controller;

import com.xworkz.formaapp.dto.UserDTO;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import javax.validation.Valid;

import com.xworkz.formaapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
@RequestMapping("/")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/userRegistration")
    public String userRegistration() {
        return "UserRegistration";
    }

    @PostMapping("registerUser")
    public ModelAndView register(@Valid @ModelAttribute UserDTO dto, BindingResult result, ModelAndView model) {

        if (result.hasErrors()) {
            result.getFieldErrors().forEach(e ->
                    model.addObject("invalid" + e.getField(), e.getDefaultMessage()));
            model.setViewName("UserRegister");
            return model;
        }

        boolean saved = userService.validateAndSave(dto);

        if (!saved) {
            model.addObject("duplicateError", "Email already exists");
            model.setViewName("UserRegister");
            return model;
        }

        model.addObject("successMsg", "Registration successful");
        model.setViewName("LoginPage");
        return model;
    }
}

