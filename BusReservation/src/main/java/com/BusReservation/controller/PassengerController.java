package com.BusReservation.controller;

import com.BusReservation.entity.Passenger;
import com.BusReservation.payload.PassengerDto;
import com.BusReservation.service.PassengerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/passenger/api/v1")
public class PassengerController {
    private PassengerService passengerService;

    public PassengerController(PassengerService passengerService) {
        this.passengerService = passengerService;
    }


    @PostMapping("book-bus")
    public ResponseEntity<?> bookBus(
            @RequestParam Long busId,
            @RequestParam Long routeId,
            @RequestBody Passenger passenger
    ){
        PassengerDto passengerDto = passengerService.bookBus(busId, routeId, passenger);
        return new ResponseEntity<>(passengerDto, HttpStatus.CREATED);
    }

}
