package com.xworkz.zapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantDTO implements Serializable {


    private String name;
    private String owner;
    private long contactNumber;
    private String address;
    private String contactEmail;
    private String type;
    private double rating;
    private String establishedYear;
    private String openingTime;
    private String closingTime;

}
