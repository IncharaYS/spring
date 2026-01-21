package com.xworkz.formaapp.repository;


import com.xworkz.formaapp.entity.UserEntity;
import java.util.Optional;


public interface UserRepository {

    boolean save(UserEntity userEntity);

    Optional<UserEntity> findByEmail(String email);

    Optional<UserEntity> findByPhoneNo(String phoneNo);
}
