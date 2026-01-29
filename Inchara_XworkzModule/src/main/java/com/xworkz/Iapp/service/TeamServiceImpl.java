package com.xworkz.Iapp.service;

import com.xworkz.Iapp.constants.IssueCode;
import com.xworkz.Iapp.dto.TeamDTO;
import com.xworkz.Iapp.dto.UserDTO;
import com.xworkz.Iapp.entity.TeamEntity;
import com.xworkz.Iapp.entity.UserEntity;
import com.xworkz.Iapp.repository.TeamRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TeamServiceImpl implements TeamService {

    @Autowired
    private TeamRepository teamRepository;

    @Override
    public IssueCode validateAndSave(TeamDTO dto, UserDTO loggedInUser) {

        if (teamRepository.findByEmail(dto.getContactEmail()).isPresent()) {
            return IssueCode.EMAILEXISTS;
        }

        TeamEntity entity = new TeamEntity();
        BeanUtils.copyProperties(dto, entity);

        UserEntity loggedInUserE=new UserEntity();
        BeanUtils.copyProperties(loggedInUser,loggedInUserE);

        entity.setCreatedByUser(loggedInUserE);
        entity.setCreatedBy(loggedInUser.getEmail());

        boolean saved = teamRepository.save(entity);

        return saved ? IssueCode.ALLOK : IssueCode.DBERROR;
    }


    @Override
    public List<TeamDTO> getAllTeams() {

        List<TeamEntity> entities = teamRepository.findAll();
        List<TeamDTO> dtoList = new ArrayList<>();

        for (TeamEntity entity : entities) {
            TeamDTO dto = new TeamDTO();
            BeanUtils.copyProperties(entity,dto);
            dtoList.add(dto);
        }

        return dtoList;
    }



        @Override
        public Optional<TeamDTO> getTeamById(int id) {

            if (id < 0 ) {
                return Optional.empty();
            }

            Optional<TeamEntity> entity = teamRepository.findById(id);

            if (!entity.isPresent()) {
                return Optional.empty();
            }

            TeamDTO dto = new TeamDTO();
            BeanUtils.copyProperties(entity.get(),dto);

            return Optional.of(dto);
        }


    @Override
    public IssueCode updateTeam(TeamDTO dto) {

        if (dto == null || dto.getTeamId() <= 0) {
            return IssueCode.INVALIDINPUT;
        }

        Optional<TeamEntity> optional = teamRepository.findById(dto.getTeamId());
        if (!optional.isPresent()) {
            return IssueCode.EMAILNOTREGISTERED;
        }

        TeamEntity entity = optional.get();

        entity.setTeamName(dto.getTeamName());
        entity.setTeamLead(dto.getTeamLead());
        entity.setProjectName(dto.getProjectName());
        entity.setDepartment(dto.getDepartment());

        boolean updated = teamRepository.updateTeam(entity);
        return updated ? IssueCode.ALLOK : IssueCode.DBERROR;
    }



    @Override
    public IssueCode deleteTeam(int id) {

        if (id <= 0) {
            return IssueCode.INVALIDINPUT;
        }
        boolean deleted = teamRepository.deleteById(id);

        return deleted ? IssueCode.ALLOK : IssueCode.DBERROR;
    }

    }

