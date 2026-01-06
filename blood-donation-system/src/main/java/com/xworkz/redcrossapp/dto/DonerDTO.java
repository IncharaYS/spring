package com.xworkz.redcrossapp.dto;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "doner_account")
public class DonerDTO implements Serializable {

    @Id
    @Column(name = "doner_account_id")
    private int id;

    @Column(name = "doner_email")
    private String donerEmail;

    @Column(name = "doner_birth_year")
    private int donerBirthYear;

    @Column(name = "doner_birth_month")
    private String donerBirthMonth;

    @Column(name = "doner_birth_day")
    private int donerBirthDay;

    @Column(name = "donor_id")
    private String donorId;

    @Column(name = "doner_first_name")
    private String donerFirstName;

    @Column(name = "doner_last_name")
    private String donerLastName;

    @Column(name = "doner_zip_code")
    private String donerZipCode;

    @Column(name = "doner_username")
    private String donerUsername;

    @Column(name = "doner_password")
    private String donerPassword;

}
