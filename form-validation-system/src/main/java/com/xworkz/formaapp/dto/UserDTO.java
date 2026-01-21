package com.xworkz.formaapp.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    @NotBlank(message = "User name is required")
    @Size(min=3,max=10,message = "Size must be between 3-10")
    private String userName;

    @Email(message = "Please enter a valid email")
    @NotBlank(message = "Email is required")
    private String email;

    @NotEmpty(message = "Phone number is required")
    @Pattern(regexp="^[6-9][0-9]{9}$",message = "Please enter a valid phone number")
    private String phoneNo;

    @NotEmpty(message = "Age is required")
    @Min(value = 18 ,message = "Minimum age should be 18")
    @Max(value = 100,message = "Maximum age should be 100")
    private int age;

    @NotBlank(message = "Gender is required")
    private String gender;

    @NotBlank(message = "Address is required")
    @Size(min = 3,max = 80,message = "Address should be between 3-80 characters")
    private String address;

    @NotBlank(message = "Password is required")
    @Pattern(regexp ="^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$" ,message = "Password must be at least 8 characters and include uppercase, lowercase, number & special character")
    private String password;

    @NotBlank(message = "Confirm password is required")
    @Pattern(regexp ="^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$" ,message = "Password must be at least 8 characters and include uppercase, lowercase, number & special character")
    private String confirmPassword;
}
