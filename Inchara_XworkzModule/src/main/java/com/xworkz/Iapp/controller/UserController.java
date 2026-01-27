package com.xworkz.Iapp.controller;

import com.mysql.cj.QueryAttributesBindings;
import com.xworkz.Iapp.constants.IssueCode;
import com.xworkz.Iapp.dto.LoginDTO;
import com.xworkz.Iapp.dto.UserDTO;
import com.xworkz.Iapp.service.EmailService;
import com.xworkz.Iapp.service.UserService;
import com.xworkz.Iapp.util.OtpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/")
public class UserController{

    @Autowired
    private UserService userService;
    @Autowired
    private EmailService emailService;
    @Autowired
    private HttpSession session;

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


    @GetMapping("profilePage")
    public ModelAndView profilePage(HttpSession session, ModelAndView model) {

        UserDTO user = (UserDTO) session.getAttribute("userInfo");

        if (user == null) {
            model.setViewName("LoginPage");
            return model;
        }

        model.addObject("userInfo", user);
        model.setViewName("ProfilePage");
        return model;
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
                    model.addObject("dto", userDTO);
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
            System.out.println(bindingResult.getAllErrors());
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

                    Optional<UserDTO> user1 =userService.findByEmail(loginDTO.getEmail());
                    int count=user1.get().getInvalidPasswordCount();
                    if(count<3) model.addObject("triesLeft","Tries left:"+(3-count));

                    model.addObject("failureMsg",IssueCode.INVALIDPWD.getMessage());
                    model.addObject("userInfo", loginDTO);

                    model.setViewName("UserLogin");
                    return model;

                case DBERROR:
                    model.addObject("serverError",IssueCode.DBERROR.getMessage());
                    model.setViewName("UserLogin");
                    return model;

                case ALLOK:
                    Optional<UserDTO> user =userService.findByEmail(loginDTO.getEmail());


                    session.setAttribute("userName", user.get().getUserName());
                    session.setAttribute("userInfo", user.get());

                    model.addObject("userName", user.get().getUserName());
                    model.addObject("userInfo", user.get());
                    model.setViewName("HomePage");
                    return model;

                default:
                    model.setViewName("HomePage");
                    return model;
            }


    }


    @GetMapping("logout")
    public ModelAndView logout(HttpSession session,ModelAndView modelAndView) {

        session.invalidate();
        modelAndView.setViewName("UserLogin");
        return modelAndView;
    }



    @PostMapping("updateUser")
    public ModelAndView updateUser(UserDTO userDTO, HttpSession session, ModelAndView model) {

        IssueCode issueCode = userService.updateUser(userDTO);

        switch (issueCode) {

            case ALLOK:
                session.setAttribute("userInfo", userDTO);
                model.addObject("successMsg", "Profile updated successfully");
                break;

            case EMAILNOTREGISTERED:
                model.addObject("failureMsg", "User not found");
                break;

            case DBERROR:
                model.addObject("failureMsg", "Unable to update profile");
                break;

            default:
                model.addObject("failureMsg", "Something went wrong");
        }

        model.addObject("userInfo", session.getAttribute("userInfo"));
        model.setViewName("ProfilePage");
        return model;
    }



    @PostMapping("deleteUser")
    public String deleteUser(HttpSession session) {

        UserDTO user = (UserDTO) session.getAttribute("userInfo");

        if (user != null) {
            userService.deleteUser(user.getEmail());
        }

        session.invalidate();
        return "redirect:/loginPage";
    }



}

