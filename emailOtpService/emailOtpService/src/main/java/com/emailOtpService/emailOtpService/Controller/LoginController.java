package com.emailOtpService.emailOtpService.Controller;

import com.emailOtpService.emailOtpService.service.EmailService;
import com.emailOtpService.emailOtpService.service.EmailVerificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class LoginController {
    private EmailVerificationService emailVerificationService;

    public LoginController(EmailVerificationService emailVerificationService) {
        this.emailVerificationService = emailVerificationService;
    }

    @PostMapping("/login-with-otp")
    public Map<String,String> logInWithOtp(@RequestParam String email){
       return emailVerificationService.verifyEmail(email);
    }

    @PostMapping("/verify-otp-for-login")
    public Map<String,String> verifyOtpForLogin(@RequestParam String email, @RequestParam String otp) {
        return emailVerificationService.verifyOtpForLogin(email, otp);
    }
}
