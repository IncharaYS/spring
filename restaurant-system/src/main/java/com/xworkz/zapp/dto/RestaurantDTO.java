package com.xworkz.zapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "restaurant")
public class RestaurantDTO implements Serializable {


    @Id
    @Column(name = "id")
    private int Id;

    @Column(name = "name")
    private String name;

    @Column(name = "owner")
    private String owner;

    @Column(name = "number")
    private long contactNumber;

    @Column(name = "address")
    private String address;

    @Column(name = "email")
    private String contactEmail;

    @Column(name = "type")
    private String type;

    @Column(name = "rating")
    private double rating;

    @Column(name = "established_year")
    private String establishedYear;

    @Column(name = "opening_time")
    private String openingTime;

    @Column(name = "closing_time")
    private String closingTime;

}
