package com.xworkz.Iapp.service;

import com.xworkz.Iapp.constants.IssueCode;
import com.xworkz.Iapp.dto.TeamDTO;
import com.xworkz.Iapp.dto.UserDTO;
import com.xworkz.Iapp.entity.UserEntity;

import java.util.List;
import java.util.Optional;

public interface TeamService {

    IssueCode validateAndSave(TeamDTO dto, UserDTO loggedInUser);

    List<TeamDTO> getAllTeams();


    Optional<TeamDTO> getTeamById(int id);

    IssueCode updateTeam(TeamDTO dto, UserDTO loggedInUser);

    IssueCode  deleteTeam(int id);

}
