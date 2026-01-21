package com.xworkz.formaapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
@NamedQueries({@NamedQuery(name = "findByEmail", query = "SELECT u FROM UserEntity u WHERE u.email=:email"),
        @NamedQuery(name = "findByPhoneNo", query = "SELECT u FROM UserEntity u WHERE u.phoneNo=:phoneNo"),
        @NamedQuery(name = "incrementCount", query = "UPDATE UserEntity u SET u.invalidPasswordCount=u.invalidPasswordCount+1 WHERE u.email=:email")
})
public class UserEntity {

    @Id
    private int userId;

    private String userName;
    private String email;
    private long phoneNo;
    private int age;
    private String gender;
    private String address;
    private String password;

    private int invalidPasswordCount;
}

