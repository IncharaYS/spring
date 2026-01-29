package com.xworkz.Iapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "team_details")
@NamedQueries({
        @NamedQuery(name = "findTeamByEmail", query = "select t from TeamEntity t where t.contactEmail = :email"),
        @NamedQuery(name = "findAllTeams", query = "select t from TeamEntity t")
})
public class TeamEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "team_id")
    private int teamId;

    @Column(name = "team_name", nullable = false, length = 30)
    private String teamName;

    @Column(name = "team_lead", nullable = false, length = 30)
    private String teamLead;

    @Column(name = "project_name", nullable = false, length = 50)
    private String projectName;

    @Column(name = "department", nullable = false, length = 30)
    private String department;

    @Column(name = "contact_email", nullable = false, unique = true, length = 50)
    private String contactEmail;

    /* ================= CREATED BY USER ================= */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "created_by_user_id", nullable = false)
    private UserEntity createdByUser;

    /* ================= TEAM MEMBERS ================= */
    @OneToMany(
            mappedBy = "team",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    private List<MemberEntity> members;
}
