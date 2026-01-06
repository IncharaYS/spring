package com.xworkz.jobportalapp.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobSeekerDTO {

    private int jobSeekerId;
    private String email;
    private String firstName;
    private String lastName;
    private String phone;
    private String location;

    private String professionalSummary;
    private String skills;


    private boolean experienced;
    private String companyName;
    private String jobTitle;
    private String fromDate;
    private String lastWorkingDate;


    private String username;
    private String password;
}
