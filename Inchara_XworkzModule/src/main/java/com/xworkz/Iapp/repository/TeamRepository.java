package com.xworkz.Iapp.repository;

import com.xworkz.Iapp.entity.TeamEntity;

import java.util.List;
import java.util.Optional;

public interface TeamRepository {

    boolean save(TeamEntity teamEntity);

    Optional<TeamEntity> findByEmail(String email);

    List<TeamEntity> findAll();

    Optional<TeamEntity> findById(int id);

    boolean updateTeam(TeamEntity entity);

    boolean deleteById(int id);

}
