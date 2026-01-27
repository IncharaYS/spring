package com.xworkz.Iapp.repository;

import com.xworkz.Iapp.entity.UserEntity;

import java.util.Optional;

public interface UserRepository {

    boolean save(UserEntity userEntity);

    Optional<UserEntity> findByEmail(String email);

    Optional<UserEntity> findByPhoneNo(String phoneNo);

    boolean updateUser(UserEntity userEntity);

    boolean deleteByEmail(String email);


}
