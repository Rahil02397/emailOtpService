package com.BusReservation.service;

import com.BusReservation.entity.Route;
import com.BusReservation.payload.RouteDto;

public interface RouteService {
    String addRoute(RouteDto routeDto);

    RouteDto searchRoute(String fromLocation, String toLocation, String fromDate);
}
