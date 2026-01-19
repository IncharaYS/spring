package com.xworkz.Iapp.controller;

import com.xworkz.Iapp.constants.IssueCode;
import com.xworkz.Iapp.dto.LoginDTO;
import com.xworkz.Iapp.dto.UserDTO;
import com.xworkz.Iapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Optional;

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

    @GetMapping("resetPasswordPage")
    public String resetPasswordPage(){
        return "ResetPassword";
    }


    @PostMapping("register")
    public ModelAndView register(@Valid @ModelAttribute UserDTO userDTO, BindingResult bindingResult, ModelAndView model) {

        if (bindingResult.hasErrors()){
            bindingResult.getFieldErrors().
                    forEach(error-> model.addObject(error.getField()+"Error",error.getDefaultMessage()));
            model.setViewName("UserRegisterPage");
            return model;
        }

            IssueCode issueCode = userService.validateAndSave(userDTO);

            switch (issueCode) {
                case PASSWORDMISMATCH:
                    model.addObject("passwordMismatch", "password should match confirm password");
                    model.setViewName("UserRegisterPage");
                    return model;

                case EMAILEXISTS:
                    model.addObject("emailError",IssueCode.EMAILEXISTS.getMessage());
                    model.addObject("dto", userDTO);
                    model.setViewName("UserRegisterPage");
                    return model;

                case  PHONENOEXISTS:
                    model.addObject("phoneNoError",IssueCode.PHONENOEXISTS.getMessage());
                    model.addObject("dto", userDTO);
                    model.setViewName("UserRegisterPage");
                    return model;


                case DBERROR:
                    model.addObject("failureMsg",IssueCode.DBERROR.getMessage());
                    model.addObject("dto", userDTO);
                    model.setViewName("UserRegisterPage");
                    return model;

                case ALLOK:
                    model.addObject("successMsg", "Registration successful. Please login.");
                    model.setViewName("UserLogin");
                    return model;


                default:
                    model.setViewName("UserLogin");
                    return model;
        }
    }



    @PostMapping("login")
    public ModelAndView login(@Valid @ModelAttribute LoginDTO loginDTO, BindingResult bindingResult, ModelAndView model) {

        if (bindingResult.hasErrors()){
            bindingResult.getFieldErrors().
                    forEach(error-> model.addObject(error.getField()+"Error",error.getDefaultMessage()));
            model.setViewName("UserLogin");
            return model;
        }

            IssueCode issueCode = userService.validateLogin(loginDTO);

            switch (issueCode){
                case EMAILNOTREGISTERED:
                    model.addObject("failureMsg",IssueCode.EMAILNOTREGISTERED.getMessage());
                    model.addObject("userInfo", loginDTO);
                    model.setViewName("UserLogin");
                    return model;


                case PWDTRIESLIMITREACHED:
                    model.addObject("enableOtp",true);
                    model.addObject("userInfo", loginDTO);
                    model.setViewName("UserLogin");
                    return model;


                case INVALIDPWD:
                    model.addObject("failureMsg",IssueCode.INVALIDPWD.getMessage());
                    model.addObject("userInfo", loginDTO);
                    model.setViewName("UserLogin");
                    return model;

                case ALLOK:
                    Optional<UserDTO> user =userService.findByEmail(loginDTO.getEmail());
                    if (user.isPresent()) {
                        model.addObject("userName", user.get().getUserName());
                        model.addObject("userInfo", user.get());
                    }
                    model.setViewName("HomePage");
                    return model;

                default:
                    model.setViewName("HomePage");
                    return model;
            }
    }

}

