package com.BusReservation.service;

import com.BusReservation.payload.SubRouteDto;
import com.BusReservation.entity.SubRoute;

import java.util.List;

public interface SubRouteService {
    String addSubRoute(SubRouteDto subRouteDto);

    List<SubRouteDto> searchSubRoute(String fromLocation, String toLocation, String fromDate);
}
