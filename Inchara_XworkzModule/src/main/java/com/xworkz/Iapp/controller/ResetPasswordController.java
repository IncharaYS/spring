package com.xworkz.Iapp.controller;

import com.xworkz.Iapp.constants.IssueCode;
import com.xworkz.Iapp.service.EmailService;
import com.xworkz.Iapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class ResetPasswordController {

    @Autowired
    private UserService userService;
    @Autowired
    private EmailService emailService;



    @GetMapping("forgotPasswordPage")
    public String forgotPasswordPage(){
        return "ForgotPasswordPage";
    }


    @GetMapping("resetPasswordPage")
    public String resetPasswordPage(){
        return "ResetPassword";
    }

    @PostMapping("sendOpt")
    public ModelAndView sendOpt(String email, ModelAndView model){

        IssueCode issueCode=emailService.sendOtpMail(email);

        switch (issueCode){
            case EMAILNOTREGISTERED:
                model.addObject("failureMsg",IssueCode.EMAILNOTREGISTERED.getMessage());
                model.addObject("email", email);
                model.setViewName("ForgotPasswordPage");
                return model;

            case OTPNOTSENT:
                model.addObject("failureMsg",IssueCode.OTPNOTSENT.getMessage());
                model.addObject("email", email);
                model.setViewName("ForgotPasswordPage");
                return model;

            case DBERROR:
                model.addObject("failureMsg",IssueCode.DBERROR.getMessage());
                model.addObject("email", email);
                model.setViewName("ForgotPasswordPage");
                return model;

            case ALLOK:
                model.addObject("successMsg", "otp sent successfully");
                model.addObject("email", email);
                model.setViewName("ResetPassword");
                return model;

            default:
                model.setViewName("ForgotPasswordPage");
                return model;
        }

    }


}
