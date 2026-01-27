package com.xworkz.Iapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
@NamedQueries({
        @NamedQuery(name="findByPhoneNo", query="select u from UserEntity u where u.phoneNo=:phoneNo"),
        @NamedQuery(name="findByEmail", query="select u from UserEntity u where u.email=:email"),
        @NamedQuery(name = "deleteByEmail",query = "delete from UserEntity u where u.email=:email")
})

public class UserEntity extends BaseEntity{

    @Id
    @Column(name = "id")
    private int userId;

    @Column(name = "name")
    private String userName;

    @Column(name = "email")
    private String email;

    @Column(name = "phone_no")
    private String phoneNo;

    @Column(name = "age")
    private String age;

    @Column(name = "gender")
    private String gender;

    @Column(name = "address")
    private String address;

    @Column(name = "password")
    private String password;

    @Column(name = "invalidPasswordCount")
    private  int invalidPasswordCount;

    @Column(name = "otp")
    private String otp;

    @Column(name = "otp_generated_time")
    private Long otpGeneratedTime;

}
