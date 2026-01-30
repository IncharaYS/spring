package com.xworkz.Iapp.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
@NamedQueries({
        @NamedQuery(name = "findByPhoneNo", query = "select u from UserEntity u where u.phoneNo = :phoneNo"),
        @NamedQuery(name = "findByEmail", query = "select u from UserEntity u where u.email = :email"),
        @NamedQuery(name = "deleteByEmail", query = "delete from UserEntity u where u.email = :email")
})
@ToString(exclude = "createdTeams")
public class UserEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int userId;

    @Column(name = "name", nullable = false, length = 50)
    private String userName;

    @Column(name = "email", nullable = false, unique = true, length = 50)
    private String email;

    @Column(name = "phone_no", nullable = false, length = 20)
    private String phoneNo;

    @Column(name = "age")
    private String age;

    @Column(name = "gender", length = 10)
    private String gender;

    @Column(name = "address", length = 255)
    private String address;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "invalid_password_count")
    private int invalidPasswordCount;

    @Column(name = "otp", length = 10)
    private String otp;

    @Column(name = "otp_generated_time")
    private Long otpGeneratedTime;

    @OneToMany(
            mappedBy = "createdByUser",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL
    )
    private List<TeamEntity> createdTeams;
}
