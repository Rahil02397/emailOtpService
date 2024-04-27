package com.BusReservation.exception;

import com.BusReservation.payload.ErrorDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(BusNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleBusNotFoundException(
            BusNotFoundException e,
            WebRequest webRequest
    ){
        ErrorDetails errorDetails = new ErrorDetails(e.getMessage(),new Date(),webRequest.getDescription(true));
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(RouteNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleRouteNotFoundException(
            RouteNotFoundException e,
            WebRequest webRequest
    ){
        ErrorDetails errorDetails = new ErrorDetails(e.getMessage(),new Date(),webRequest.getDescription(true));
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // Add more exception handler methods for other custom exceptions

}
