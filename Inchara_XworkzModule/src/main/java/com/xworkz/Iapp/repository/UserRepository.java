package com.xworkz.Iapp.repository;

import com.xworkz.Iapp.entity.UserEntity;

import java.util.Optional;

public interface UserRepository {

    boolean save(UserEntity userEntity);

    Optional<UserEntity> findByEmail(String email);
}
