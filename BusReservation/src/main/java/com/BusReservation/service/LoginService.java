package com.BusReservation.service;

import com.BusReservation.entity.User;
import com.BusReservation.exception.UserNotFoundException;

public interface LoginService {
    String logIn(User user) throws UserNotFoundException;
}
