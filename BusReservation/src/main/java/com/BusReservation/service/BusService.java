package com.BusReservation.service;


import com.BusReservation.payload.BusDto;

import java.util.List;

public interface BusService {

    String deleteBusById(long busId);

    String addBus(BusDto busDto);

    List<BusDto> searchBus(String fromLocation, String toLocation, String fromDate);
}
