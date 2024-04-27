package com.BusReservation.controller;

import com.BusReservation.payload.SubRouteDto;
import com.BusReservation.service.SubRouteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/sub-route")
public class SubRouteController {

    private SubRouteService subRouteService;

    public SubRouteController(SubRouteService subRouteService) {
        this.subRouteService = subRouteService;
    }

    @PostMapping("/add-sub-route")
    public ResponseEntity<?> addSubRoute(
            @RequestBody SubRouteDto subRouteDto
            ){
        String message = subRouteService.addSubRoute(subRouteDto);
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }
}
