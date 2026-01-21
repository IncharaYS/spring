package com.xworkz.formaapp.service;
;

import com.xworkz.formaapp.entity.UserEntity;
import com.xworkz.formaapp.repository.UserRepository;
import com.xworkz.formaapp.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Override
    public boolean validateAndSave(UserDTO dto) {

        // Email duplicate check
        if (repository.findByEmail(dto.getEmail()).isPresent()) {
            return false;
        }

        UserEntity entity = new UserEntity();
        entity.setUserName(dto.getUserName());
        entity.setEmail(dto.getEmail());
        entity.setPhoneNo(Long.parseLong(dto.getPhoneNo()));
        entity.setAge(dto.getAge());
        entity.setGender(dto.getGender());
        entity.setAddress(dto.getAddress());
        entity.setPassword(dto.getPassword());

        return repository.save(entity);
    }
}
