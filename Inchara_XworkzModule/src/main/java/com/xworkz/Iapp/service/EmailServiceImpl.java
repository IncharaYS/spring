package com.xworkz.Iapp.service;

import com.xworkz.Iapp.constants.IssueCode;
import com.xworkz.Iapp.dto.UserDTO;
import com.xworkz.Iapp.entity.UserEntity;
import com.xworkz.Iapp.repository.UserRepository;
import com.xworkz.Iapp.util.EncryptionUtil;
import com.xworkz.Iapp.util.OtpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.xworkz.Iapp.constants.IssueCode.*;

@Service
public class EmailServiceImpl implements EmailService{


    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private UserRepository userRepository;

    @Override
    public IssueCode sendOtpMail(String toEmail) {

         Optional<UserEntity> user =userRepository.findByEmail(toEmail);
         if(!user.isPresent()){
             return EMAILNOTREGISTERED;
         }

        String otp= OtpUtil.generateOtp();
        System.out.println(otp);

        try {

            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(toEmail);

            message.setSubject("OTP Verification");
            message.setText(
                    "Your OTP for verification is: " + otp +
                            "\n\nThis OTP is valid for 1 minute.\n\n" +
                            "Do not share this OTP with anyone."
            );



            mailSender.send(message);

            UserEntity userEntity=user.get();
            userEntity.setOtp(EncryptionUtil.encrypt(otp));

            userEntity.setOtpGeneratedTime(System.currentTimeMillis());

            boolean isUpdated=userRepository.updateUser(userEntity);
            if(!isUpdated) return DBERROR;

            return ALLOK;

        }
        catch (Exception e) {
            e.printStackTrace();
            return OTPNOTSENT;
        }
    }
}
