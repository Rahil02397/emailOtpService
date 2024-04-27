package com.BusReservation.service;

import com.BusReservation.entity.User;
import com.BusReservation.payload.UserDto;
import org.springframework.web.multipart.MultipartFile;

public interface UserService {

    String createUser(UserDto userDto);

    UserDto getUser(Long id);
}
