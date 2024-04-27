package com.BusReservation.service;

import com.BusReservation.payload.DriverDto;

public interface DriverService {
    String addDriver(DriverDto driverDto);

    String deleteDriver(long driverId);
}
