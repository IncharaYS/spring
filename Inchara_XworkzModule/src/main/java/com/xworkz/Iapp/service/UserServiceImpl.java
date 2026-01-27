package com.xworkz.Iapp.service;

import com.xworkz.Iapp.constants.IssueCode;
import com.xworkz.Iapp.dto.LoginDTO;
import com.xworkz.Iapp.dto.UserDTO;
import com.xworkz.Iapp.dto.ValidationResponseDTO;
import com.xworkz.Iapp.entity.UserEntity;
import com.xworkz.Iapp.repository.UserRepository;
import com.xworkz.Iapp.util.EncryptionUtil;
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

            userEntity.setPassword(EncryptionUtil.encrypt(userDTO.getPassword()));

            userEntity.setCreatedBy(userDTO.getUserName());
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

            String decryptedPassword = EncryptionUtil.decrypt(entity.getPassword());
            if (!decryptedPassword.equals(loginDTO.getPassword())) {

//            if(bCryptPasswordEncoder.matches(userDTO.getPassword(), entity.getPassword())){

                entity.setInvalidPasswordCount(user.get().getInvalidPasswordCount()+1);
                boolean isUpdated=userRepository.updateUser(entity);
                if(!isUpdated) return DBERROR;

                return IssueCode.INVALIDPWD;
            }

            entity.setInvalidPasswordCount(0);
            boolean isUpdated=userRepository.updateUser(entity);
            if(!isUpdated) return DBERROR;
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

    @Override
    public ValidationResponseDTO emailExists(String email) {
        Optional<UserEntity> user=userRepository.findByEmail(email);

        System.out.println("For email:"+email+":"+user.isPresent());

        ValidationResponseDTO response=new ValidationResponseDTO();

        System.out.println(user);


        if(user.isPresent()){
            response.setAttempts(user.get().getInvalidPasswordCount());
            response.setExists(true);
        }

        System.out.println(response);
        return response;
    }

    @Override
    public boolean phoneNoExists(String phoneNo) {
        Optional<UserEntity> user=userRepository.findByPhoneNo(phoneNo);
        return user.isPresent();
    }

    @Override
    public IssueCode verifyOtp(String email, String otp) {

        Optional<UserEntity> user = userRepository.findByEmail(email);

        if (!user.isPresent()) {
            return IssueCode.EMAILNOTREGISTERED;
        }

        UserEntity entity = user.get();

        Long otpTime = entity.getOtpGeneratedTime();

        if (otpTime == null || System.currentTimeMillis() - entity.getOtpGeneratedTime() > 60000) {
            return IssueCode.OTPEXPIRED;
        }


        if (!otp.equals(EncryptionUtil.decrypt(entity.getOtp()))) {
            return IssueCode.INVALIDOTP;
        }

        return IssueCode.ALLOK;
    }

    @Override
    public IssueCode resetPassword(String email, String password) {

        Optional<UserEntity> user = userRepository.findByEmail(email);

        if (!user.isPresent()) {
            return IssueCode.EMAILNOTREGISTERED;
        }

        UserEntity entity = user.get();
        entity.setPassword(EncryptionUtil.encrypt(password));
        entity.setOtp(null);
        entity.setOtpGeneratedTime(null);

        boolean updated = userRepository.updateUser(entity);

        return updated ? IssueCode.ALLOK : IssueCode.DBERROR;
    }



    private boolean checkConfirmPassword(String password,String cPassword){
        return password.equals(cPassword);
    }



        @Override
        public IssueCode updateUser(UserDTO userDTO) {

            Optional<UserEntity> optionalEntity = userRepository.findByEmail(userDTO.getEmail());

            if (!optionalEntity.isPresent()) {
                return IssueCode.EMAILNOTREGISTERED;
            }

            UserEntity entity = optionalEntity.get();

            entity.setUserName(userDTO.getUserName());
            entity.setAge(userDTO.getAge());
            entity.setGender(userDTO.getGender());
            entity.setAddress(userDTO.getAddress());

            boolean updated = userRepository.updateUser(entity);
            return updated ? IssueCode.ALLOK : IssueCode.DBERROR;
        }

        @Override
        public IssueCode deleteUser(String email) {

            Optional<UserEntity> optionalEntity = userRepository.findByEmail(email);

            if (!optionalEntity.isPresent()) {
                return IssueCode.EMAILNOTREGISTERED;
            }

            boolean deleted = userRepository.deleteByEmail(email);

            return deleted ? IssueCode.ALLOK : IssueCode.DBERROR;
        }
    }


