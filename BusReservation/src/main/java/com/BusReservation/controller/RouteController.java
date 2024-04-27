package com.BusReservation.controller;

import com.BusReservation.payload.RouteDto;
import com.BusReservation.service.RouteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/route")
public class RouteController {

    private RouteService routeService;
    public RouteController(RouteService routeService) {
        this.routeService = routeService;
    }

    @PostMapping("/add-driver")
    public ResponseEntity<?> addRoute(
            @RequestBody RouteDto routeDto
    ){
        String message=routeService.addRoute(routeDto);
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }
}
