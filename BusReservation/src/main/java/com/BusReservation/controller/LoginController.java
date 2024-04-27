package com.BusReservation.controller;

import com.BusReservation.entity.User;
import com.BusReservation.service.LoginService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RequestMapping
public class LoginController {

    private LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    public ResponseEntity<?> logIn(
            @RequestBody User user
    ){
        loginService.logIn(user);
        return null;
    }
}
