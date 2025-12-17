package com.xworkz.travelAgencyApp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO implements Serializable {

    private String fullName;
    private String email;
    private String password;
    private long phoneNo;
    private String country;
    private boolean isDeleted;

}
