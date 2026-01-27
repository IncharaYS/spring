package com.xworkz.Iapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "team_details")
@NamedQueries({@NamedQuery(name="findTeamByEmail",query="select t from TeamEntity t WHERE t.contactEmail = :email"),
            @NamedQuery(name="findAllTeams", query = "select t from TeamEntity t")})


public class TeamEntity extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "team_id")
    private int teamId;

    @Column(name = "team_name", nullable = false, length = 30)
    private String teamName;

    @Column(name = "team_lead", nullable = false, length = 30)
    private String teamLead;

    @Column(name = "team_size", nullable = false)
    private Integer teamSize;

    @Column(name = "project_name", nullable = false, length = 50)
    private String projectName;

    @Column(name = "department", nullable = false, length = 30)
    private String department;

    @Column(name = "contact_email", nullable = false, unique = true, length = 50)
    private String contactEmail;
}
