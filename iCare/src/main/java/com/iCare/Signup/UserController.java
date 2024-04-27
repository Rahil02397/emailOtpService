package com.iCare.Signup;

import com.iCare.JWT.JWTResponse;
import com.iCare.Signup.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    //http://localhost:8080/api/v1/user/sign-up
    @PostMapping("/sign-up")
    public ResponseEntity<?> signUp(@RequestBody UserDto userDto){
        userService.signUp(userDto);
        return new ResponseEntity<>("OK", HttpStatus.CREATED);
    }

    @PostMapping("/sign")
    public ResponseEntity<?> signIn(@RequestBody SignInDto signInDto){
        String message = userService.verifySignIn(signInDto);
        if(message!=null){
            JWTResponse response = new JWTResponse();
            response.setToken(message);
            return new ResponseEntity<>(response,HttpStatus.OK);
        }
        return new ResponseEntity<>( "signin failed",HttpStatus.OK);
    }
}
