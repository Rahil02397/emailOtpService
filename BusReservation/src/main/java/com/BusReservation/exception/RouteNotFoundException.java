package com.BusReservation.exception;

public class RouteNotFoundException extends RuntimeException{
    public RouteNotFoundException(String message) {
        super(message);
    }
}
