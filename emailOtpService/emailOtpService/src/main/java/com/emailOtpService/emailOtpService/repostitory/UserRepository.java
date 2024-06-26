package com.emailOtpService.emailOtpService.repostitory;

import com.emailOtpService.emailOtpService.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {


    UserEntity findByEmail(String email);
}
