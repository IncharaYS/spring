package com.xworkz.redcrossapp.dto;

import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DonerDTO implements Serializable {

    private int id;
    private String donerEmail;
    private int donerBirthYear;
    private String donerBirthMonth;
    private int donerBirthDay;
    private String donorId;
    private String donerFirstName;
    private String donerLastName;
    private String donerZipCode;
    private String donerUsername;
    private String donerPassword;

}
