package com.xworkz.Iapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO implements Serializable {

    private int userId;
    @NotBlank(message = "Please enter user name")
    @Size(min = 3,max = 10,message = "name should be between 3-10 characters")
    @Pattern(regexp = "^[A-Za-z\\s]+$" ,message = "Name should only contain alphabets")
    private String userName;
    private String email;
    private long phoneNo;
    private int age;
    private String gender;
    private String address;
    private String password;
    private String confirmPassword;


}
