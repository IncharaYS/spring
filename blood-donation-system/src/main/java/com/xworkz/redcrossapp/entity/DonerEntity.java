package com.xworkz.redcrossapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;



@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@NamedQueries({
        @NamedQuery(name = "findByEmail",query = "from DonerEntity e where e.donerEmail=:email"),
        @NamedQuery(name ="update" ,query = "update DonerEntity d set " +
                "d.donorId=:donerId,d.donerFirstName=:firstName,d.donerLastName=:lastName,d.donerZipCode=:zipCode,d.donerUsername=:userName,d.donerPassword=:password where d.id=:id"),
        @NamedQuery(name = "deleteById",query = "delete DonerEntity e where e.id=:eId")
})
@Table(name = "doner_account")
public class DonerEntity {

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
