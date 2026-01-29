package com.xworkz.Iapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeamDTO {

    @Id
    private int teamId;

    @NotBlank(message = "Team name is required")
    @Size(min = 3, max = 30, message = "Team name must be between 3 and 30 characters")
    private String teamName;

    @NotBlank(message = "Team lead name is required")
    @Size(min = 3, max = 30, message = "Team lead name must be between 3 and 30 characters")
    private String teamLead;

    @NotBlank(message = "Project name is required")
    @Size(min = 3, max = 50, message = "Project name must be between 3 and 50 characters")
    private String projectName;

    @NotBlank(message = "Department is required")
    private String department;

    @NotBlank(message = "Team email is required")
    @Email(message = "Please enter a valid team email")
    private String contactEmail;
}
