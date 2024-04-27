package com.BusReservation.controller;

import com.BusReservation.payload.UserDto;
import com.BusReservation.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("user/api/v1")
public class UserController {

    private UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/save-user")
    public ResponseEntity<String> createUser(
            @RequestParam("profilePicture") MultipartFile profilePicture,
            @RequestParam("userName") String userName,
            @RequestParam("emailId") String emailId,
            @RequestParam("password") String password) throws IOException {
        UserDto userDto = new UserDto();
        userDto.setUserName(userName);
        userDto.setEmailId(emailId);
        userDto.setProfilePicture(profilePicture.getBytes());
        userDto.setPassword(password);
        String message = userService.createUser(userDto);
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }

    @GetMapping("/get-user-by-id")
    public ResponseEntity<UserDto> getUser(@RequestParam Long Id){
        UserDto userDto = userService.getUser(Id);
        return new ResponseEntity<>(userDto,HttpStatus.OK);
    }
}
