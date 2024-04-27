package com.BusReservation.service.ServiceImpl;

import com.BusReservation.entity.User;
import com.BusReservation.exception.UserNotFoundException;
import com.BusReservation.repository.UserRepository;
import com.BusReservation.service.LoginService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LoginServiceImpl implements LoginService {
    private UserRepository userRepository;

    private HttpSession httpSession;
    public LoginServiceImpl(UserRepository userRepository, HttpSession httpSession) {
        this.userRepository = userRepository;
        this.httpSession = httpSession;
    }

    @Override
    public String logIn(User user) throws UserNotFoundException {

        User existingUser = userRepository.findByUserName(user.getUserName());
        String emailId = existingUser.getEmailId();
        String password = existingUser.getPassword();
        if(emailId != null && !emailId.equals(user.getEmailId())) {
        throw new UserNotFoundException("Incorrect emailId!!");
        }
        if(password != null && !password.equals(user.getPassword())){
            throw new UserNotFoundException("Incorrect password!!");
        }else {
            httpSession.setAttribute("user", user);
            return "Login successful";
        }
    }
}
