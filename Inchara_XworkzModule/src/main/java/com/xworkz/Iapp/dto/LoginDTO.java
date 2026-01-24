package com.xworkz.Iapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
public class LoginDTO {

    @NotBlank(message = "Please enter email")
   @Email(message = "Enter valid email")
    private String email;

    @NotBlank(message = "Please enter password")
    @Pattern(regexp ="^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$" ,message = "Password must be at least 8 characters and include uppercase, lowercase, number & special character")
    private String password;

}
