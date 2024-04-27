package com.BusReservation.service;

import com.BusReservation.entity.Passenger;
import com.BusReservation.payload.PassengerDto;

public interface PassengerService {
    PassengerDto bookBus(Long busId, Long routeId, Passenger passenger);
}
