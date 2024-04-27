package com.emailOtpService.emailOtpService.service;
import com.emailOtpService.emailOtpService.entity.UserEntity;
import com.emailOtpService.emailOtpService.repostitory.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public UserEntity registerUser(UserEntity user){
        return userRepository.save(user);
    }

    public UserEntity getUserByEmail(String email) {
       return userRepository.findByEmail(email);
    }

    public void verifyEmail(UserEntity user) {
        user.setEmailVerified(true);
        userRepository.save(user);
    }

    public boolean isEmailVerified(String email) {
        UserEntity user = userRepository.findByEmail(email);
        return user!=null && user.isEmailVerified();
    }
}
