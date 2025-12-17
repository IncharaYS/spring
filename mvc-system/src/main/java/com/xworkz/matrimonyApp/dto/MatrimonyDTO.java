package com.xworkz.matrimonyApp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MatrimonyDTO implements Serializable {

    private String email;
    private String createProfileFor;
    private String gender;
    private String dateOfBirth;
    private String motherTongue;
    private String religion;
    private String maritalStatus;
    private double height;

}
