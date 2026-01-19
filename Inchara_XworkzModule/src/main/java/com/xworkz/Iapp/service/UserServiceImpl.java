package com.xworkz.Iapp.service;

import com.xworkz.Iapp.constants.IssueCode;
import com.xworkz.Iapp.dto.LoginDTO;
import com.xworkz.Iapp.dto.UserDTO;
import com.xworkz.Iapp.entity.UserEntity;
import com.xworkz.Iapp.repository.UserRepository;
import com.xworkz.Iapp.util.Encryption;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.xworkz.Iapp.constants.IssueCode.DBERROR;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

//    @Autowired
//    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @Override
    public IssueCode validateAndSave(UserDTO userDTO) {

        if(!checkConfirmPassword(userDTO.getPassword(),userDTO.getConfirmPassword())){
            return IssueCode.PASSWORDMISMATCH;
        }

        Optional<UserEntity> existingUser = userRepository.findByEmail(userDTO.getEmail());

        if (existingUser.isPresent()) {
            System.err.println("Email already exists: " + userDTO.getEmail());
            return IssueCode.EMAILEXISTS;
        }

        if(userRepository.findByPhoneNo(userDTO.getPhoneNo()).isPresent()){
            System.err.println("Entered phone number already exists");
            return IssueCode.PHONENOEXISTS;
        }

            System.out.println(userDTO);
            UserEntity userEntity = new UserEntity();
            BeanUtils.copyProperties(userDTO, userEntity);

//        userEntity.setPassword(bCryptPasswordEncoder.encode(userDTO.getPassword()));

            userEntity.setPassword(Encryption.encrypt(userDTO.getPassword()));

            System.out.println(userEntity);

            boolean isSaved = userRepository.save(userEntity);

            if (isSaved) {
                System.out.println("User saved successfully");
            } else {
                System.err.println("Failed to save user");
                return DBERROR;
            }

        return IssueCode.ALLOK;
    }



    @Override
    public IssueCode validateLogin(LoginDTO loginDTO) {

        Optional<UserEntity> user = userRepository.findByEmail(loginDTO.getEmail());

        if (!user.isPresent()) {
            return IssueCode.EMAILNOTREGISTERED;
        }

        UserEntity entity = user.get();

        if(entity.getInvalidPasswordCount()<3) {

            String decryptedPassword = Encryption.decrypt(entity.getPassword());
            if (!decryptedPassword.equals(loginDTO.getPassword())) {

//            if(bCryptPasswordEncoder.matches(userDTO.getPassword(), entity.getPassword())){

                userRepository.incrementCount(loginDTO.getEmail());
                return IssueCode.INVALIDPWD;
            }

            return IssueCode.ALLOK;
        }
        else {
            System.out.println("Entered invalid password 3 or more times");
            return IssueCode.PWDTRIESLIMITREACHED;
        }
    }

    @Override
    public Optional<UserDTO> findByEmail(String email) {

        Optional<UserEntity> user=userRepository.findByEmail(email);

        System.out.println(user);
        if(user.isPresent()){
            UserDTO dto=new UserDTO();
            BeanUtils.copyProperties(user.get(),dto);

            System.out.println(dto);
            return Optional.of(dto);
        }

        return Optional.empty();
    }


    private boolean checkConfirmPassword(String password,String cPassword){
        return password.equals(cPassword);
    }
}
