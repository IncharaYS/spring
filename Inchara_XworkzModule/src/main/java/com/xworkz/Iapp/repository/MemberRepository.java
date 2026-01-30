package com.xworkz.Iapp.repository;

import com.xworkz.Iapp.entity.MemberEntity;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {

    boolean save(MemberEntity entity);

    List<MemberEntity> findByTeamId(int teamId);

    Optional<MemberEntity> findById(int memberId);

    boolean update(MemberEntity entity);

    boolean delete(int memberId);
}


