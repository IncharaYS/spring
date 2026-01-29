package com.xworkz.Iapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "team_members")
public class MemberEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private int memberId;

    @Column(name = "member_name", nullable = false, length = 50)
    private String memberName;

    @Column(name = "member_email", nullable = false, length = 50)
    private String memberEmail;

    @Column(name = "role", length = 30)
    private String role;

    /* ================= TEAM RELATION ================= */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id", nullable = false)
    private TeamEntity team;
}
