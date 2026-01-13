package com.xworkz.redcrossapp.repository;

import com.xworkz.redcrossapp.dto.SearchDTO;
import com.xworkz.redcrossapp.entity.DonerEntity;

import java.util.Optional;

public interface DonerAccountRepository {

    boolean save(DonerEntity donerEntity);
    Optional<DonerEntity> findByEmail(String email);
    boolean update(DonerEntity donerEntity);
    boolean deleteByEmail(String email);
    boolean deleteById(int id);
}
