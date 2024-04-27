package com.BusReservation.controller;
import com.BusReservation.entity.Route;
import com.BusReservation.payload.BusDto;
import com.BusReservation.service.BusService;
import com.BusReservation.service.RouteService;
import com.BusReservation.service.SubRouteService;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bus/api/v1")
public class BusController {

    private BusService busService;
    private RouteService routeService;
    private SubRouteService subRouteService;
    public BusController(BusService busService, RouteService routeService, SubRouteService subRouteService) {
        this.busService = busService;
        this.routeService = routeService;
        this.subRouteService = subRouteService;
    }

    @PostMapping("/save-bus")
    public ResponseEntity<String> addBus(
            @RequestBody BusDto busDto){
        String message = busService.addBus(busDto);
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }
    
    @DeleteMapping("/delete-bus")
    public ResponseEntity<?> deleteBusById(
            @RequestParam long busId
    ){
        String message = busService.deleteBusById(busId);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @GetMapping("/search-bus")
    public ResponseEntity<?> searchBus(
            @RequestParam String fromLocation,
            @RequestParam String toLocation,
            @RequestParam String fromDate
    ){
        List<BusDto> busDtos = busService.searchBus(fromLocation, toLocation, fromDate);
        return new ResponseEntity<>(busDtos, HttpStatus.OK);
    }

}
