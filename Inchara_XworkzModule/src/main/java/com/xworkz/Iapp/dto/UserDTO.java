package com.xworkz.Iapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.NamedQueries;
import javax.validation.constraints.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO implements Serializable {

    private int userId;

    @NotBlank(message = "Please enter user name")
    @Size(min = 3,max = 20,message = "name should be between 3-20 characters")
    @Pattern(regexp = "^[A-Za-z\\s]+$" ,message = "Name should only contain alphabets")
    private String userName;

    @NotBlank(message = "Please enter email")
    @Size(min = 6,max = 20,message = "email should be between 6-20 characters")
    @Email(message = "Enter valid email")
    private String email;

    @NotBlank(message = "Please enter phone number")
    @Size(min =10,max = 12,message = "Enter a valid phone number")
    @Pattern(regexp = "^[6-9][0-9]{9}$",message = "Phone must start with 6,7,8 or 9 and be 10 digits")
    private String phoneNo;

    @NotBlank(message = "Please enter age")
    @Min(value = 18 ,message = "Age should be above 18")
    @Max(value = 100, message = "Age should be below 100")
    private String age;

    @NotBlank(message = "Please enter gender")
    private String gender;

    @NotBlank(message = "Please enter address")
    private String address;

    @NotBlank(message = "Please enter password")
    @Pattern(regexp ="^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$" ,message = "Password must be at least 8 characters and include uppercase, lowercase, number & special character")
    private String password;

    private String confirmPassword;

    private  int invalidPasswordCount;


}
