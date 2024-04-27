package com.emailOtpService.emailOtpService.service;

import com.emailOtpService.emailOtpService.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmailVerificationService {
    @Autowired
    private UserService userService;
    @Autowired
    private EmailService emailService;

    static final Map<String, String> emailOtpMapping = new HashMap<>();


    public Map<String, String> verifyOtp(String email, String otp) {
        String storedOtp = emailOtpMapping.get(email);

        Map<String, String> response = new HashMap<>();
        if (storedOtp != null && storedOtp.equals(otp)) {
            //    logger.info("OTP is valid. Proceeding with verification");

            UserEntity user = userService.getUserByEmail(email);
            if (user != null) {
                emailOtpMapping.remove(email);
                userService.verifyEmail(user);
                response.put("status", "success");
                response.put("message", "Email verified");
            } else {
                //      logger.error("Invalid OTP received for email:{}",email);
                response.put("status", "error");
                response.put("message", "User not found");
            }
        } else {
            response.put("status", "error");
            response.put("message", "Invalid OTP");
        }
        return response;

    }

    public Map<String, String> verifyEmail(String email) {
        if (userService.isEmailVerified(email)) {
            String otp = emailService.generateOtp();
            emailOtpMapping.put(email,otp);
            emailService.sendOtp(email);
            //    logger.info("OTP is valid. Proceeding with verification");
            Map<String, String> response = new HashMap<>();

            response.put("status", "success");
            response.put("message", "OTP sent successfully");
            return response;
        } else {
            Map<String, String> response = new HashMap<>();

            //      logger.error("Invalid OTP received for email:{}",email);
            response.put("status", "error");
            response.put("message", "Email not verified");
            return response;

        }
    }
    public Map<String, String> verifyOtpForLogin(String email, String otp) {
        String storedOtp = emailOtpMapping.get(email);

        Map<String, String> response = new HashMap<>();
        if (storedOtp != null && storedOtp.equals(otp)) {

                response.put("status", "success");
                response.put("message", "Email verified");
            } else {
                //      logger.error("Invalid OTP received for email:{}",email);
                response.put("status", "error");
                response.put("message", "User not found");
            }
        return response;

    }
}

