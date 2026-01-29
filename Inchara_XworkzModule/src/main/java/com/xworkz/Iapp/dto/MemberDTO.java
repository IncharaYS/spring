package com.xworkz.Iapp.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberDTO {

    private int memberId;

    @NotBlank(message = "Member name is required")
    @Size(min = 3, max = 50, message = "Member name must be between 3 and 50 characters")
    private String memberName;

    @NotBlank(message = "Member email is required")
    @Email(message = "Please enter a valid email")
    private String memberEmail;

    @Size(max = 30, message = "Role must not exceed 30 characters")
    private String role;

    private int teamId;
}
