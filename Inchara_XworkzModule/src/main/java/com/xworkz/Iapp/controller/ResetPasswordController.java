    package com.xworkz.Iapp.controller;
    
    import com.xworkz.Iapp.constants.IssueCode;
    import com.xworkz.Iapp.dto.UserDTO;
    import com.xworkz.Iapp.entity.UserEntity;
    import com.xworkz.Iapp.service.EmailService;
    import com.xworkz.Iapp.service.UserService;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Controller;
    import org.springframework.web.bind.annotation.GetMapping;
    import org.springframework.web.bind.annotation.PostMapping;
    import org.springframework.web.bind.annotation.RequestMapping;
    import org.springframework.web.servlet.ModelAndView;

    import java.util.Optional;

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
                    model.setViewName("OtpPage");
                    return model;
    
                default:
                    model.setViewName("ForgotPasswordPage");
                    return model;
            }
    
        }


        @PostMapping("verifyOtp")
        public ModelAndView verifyOtp(String email, String otp, ModelAndView model) {

            Optional<UserDTO> userOpt = userService.findByEmail(email);

            if (!userOpt.isPresent()) {
                model.setViewName("ForgotPasswordPage");
                return model;
            }

            UserDTO user = userOpt.get();

            long now = System.currentTimeMillis();
            long generatedTime = user.getOtpGeneratedTime();

            long remainingTime = 60 -((now-generatedTime) / 1000);
            if (remainingTime < 0) {
                remainingTime = 0;
            }

            IssueCode issueCode = userService.verifyOtp(email, otp);

            switch (issueCode) {

                case INVALIDOTP:
                    model.addObject("failureMsg", "Invalid OTP");
                    model.addObject("email", email);
                    model.addObject("remainingTime", remainingTime);
                    model.setViewName("OtpPage");
                    return model;

                case OTPEXPIRED:
                    model.addObject("failureMsg", "OTP expired. Please resend.");
                    model.addObject("email", email);
                    model.addObject("remainingTime", 0);
                    model.setViewName("OtpPage");
                    return model;

                case ALLOK:
                    model.addObject("email", email);
                    model.setViewName("ResetPassword");
                    return model;

                default:
                    model.setViewName("OtpPage");
                    return model;
            }
        }



        @PostMapping("resendOtp")
        public ModelAndView resendOtp(String email, ModelAndView model) {

            IssueCode issueCode = emailService.sendOtpMail(email);

            if (issueCode == IssueCode.ALLOK) {
                model.addObject("successMsg", "OTP resent successfully");
                model.addObject("email", email);
                model.setViewName("OtpPage");
            } else {
                model.addObject("failureMsg", "Unable to resend OTP");
                model.addObject("email", email);
                model.setViewName("OtpPage");
            }

            return model;
        }

        @PostMapping("resetPassword")
        public ModelAndView resetPassword(String email, String password, String confirmPassword, ModelAndView model) {

            if (!password.equals(confirmPassword)) {
                model.addObject("failureMsg", "Passwords do not match");
                model.addObject("email", email);
                model.setViewName("ResetPassword");
                return model;
            }

            IssueCode issueCode = userService.resetPassword(email, password);

            if (issueCode == IssueCode.ALLOK) {
                model.addObject("successMsg", "Password reset successful");
                model.setViewName("UserLogin");
            } else {
                model.addObject("failureMsg", "Unable to reset password");
                model.setViewName("ResetPassword");
            }

            return model;
        }





    }
