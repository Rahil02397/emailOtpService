package com.emailOtpService.emailOtpService.Controller;

import com.emailOtpService.emailOtpService.entity.UserEntity;
import com.emailOtpService.emailOtpService.service.EmailService;
import com.emailOtpService.emailOtpService.service.EmailVerificationService;
import com.emailOtpService.emailOtpService.service.UserService;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class RegistrationController {
    private UserService userService;
    private EmailService emailService;
    private EmailVerificationService emailVerificationService;

    public RegistrationController(UserService userService,
                                  EmailService emailService,
                                  EmailVerificationService emailVerificationService){
        this.userService = userService;
        this.emailService = emailService;
        this.emailVerificationService = emailVerificationService;
    }


    @PostMapping("/send-otp")
    public Map<String,String> registerUser(@RequestBody UserEntity user) {
        if (userService.isEmailVerified(user.getEmail())) {
            Map<String, String> response = new HashMap<>();
            response.put("status", "Error");
            response.put("message", "user already registered. Please use another email");
            return response;
        } else {
            UserEntity registeredUser = userService.registerUser(user);
            emailService.sendOtp(user.getEmail());
            Map<String, String> response = new HashMap<>();
            response.put("status", "success");
            response.put("message", "user registered successfully. Check your email for verification");
            return response;
        }
    }

    @PostMapping("/verify-otp")
    public Map<String,String> verifyOtp(@RequestParam String email, @RequestParam String otp) {
        return emailVerificationService.verifyOtp(email, otp);
        }
    }


