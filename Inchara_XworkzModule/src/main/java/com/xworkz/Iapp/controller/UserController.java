package com.xworkz.Iapp.controller;

import com.xworkz.Iapp.dto.UserDTO;
import com.xworkz.Iapp.exceptions.DuplicateEmailException;
import com.xworkz.Iapp.exceptions.EmailNotRegisteredException;
import com.xworkz.Iapp.exceptions.InvalidPasswordException;
import com.xworkz.Iapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("/")
public class UserController{

    @Autowired
    private UserService userService;

    @GetMapping("loginPage")
    public String loginPage(){
        return "UserLogin";
    }

    @GetMapping("registerPage")
    public String registerPage(){
        return "UserRegisterPage";
    }

    @GetMapping("homePage")
    public String homePage(){
        return "HomePage";
    }



    @PostMapping("register")
    public ModelAndView register(@Valid @ModelAttribute UserDTO userDTO, BindingResult bindingResult, ModelAndView model) {

        if(bindingResult.hasErrors()){
            if (bindingResult.hasFieldErrors("userName")){
                System.out.println(bindingResult.getFieldError("userName").getDefaultMessage());
                model.addObject("invalidField",bindingResult.getFieldError("userName").getDefaultMessage());
            }

            model.setViewName("UserRegisterPage");
            return model;
        }

        System.out.println("Password(for ref)"+userDTO.getPassword());

        try {
            boolean saved = userService.validateAndSave(userDTO);

            if (saved) {
                model.addObject("successMsg", "Registration successful. Please login.");
                model.setViewName("UserLogin");
                return model;
            }
            else {
                model.addObject("failureMsg", "Registration failed. Try again.");
                model.addObject("dto", userDTO);
                model.setViewName("UserRegisterPage");
                return model;
            }

        } catch (DuplicateEmailException e) {
            model.addObject("failureMsg", e.getMessage());
            model.addObject("dto", userDTO);
            model.setViewName("UserRegisterPage");
            return model;
        }
    }



    @PostMapping("login")
    public ModelAndView login(@Valid @ModelAttribute UserDTO userDTO, BindingResult bindingResult, ModelAndView model) {

        try {
            UserDTO loggedInUser =
                    userService.validateLogin(userDTO);

            model.addObject("userName", loggedInUser.getUserName());
            model.addObject("userInfo", loggedInUser);
            model.setViewName("HomePage");
            return model;

        } catch (EmailNotRegisteredException e) {

            model.addObject("failureMsg", e.getMessage());
            model.addObject("userInfo", userDTO);
            model.setViewName("UserLogin");
            return model;

        } catch (InvalidPasswordException e) {

            model.addObject("failureMsg", e.getMessage());
            model.addObject("userInfo", userDTO);
            model.setViewName("UserLogin");
            return model;
        }
    }

}

