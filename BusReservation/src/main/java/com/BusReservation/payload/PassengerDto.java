package com.BusReservation.payload;

import lombok.Data;

@Data
public class PassengerDto {

    private Long id;
    private String firstName;
    private String lastName;
    private Long contactNumber;
    private String email;
    private String dob;

    private String number;
    private String type;
    private Double price;
    private int totalSeats;
    private int availableSeats;

    private String fromLocation;
    private String toLocation;
    private String fromDate;
    private String toDate;
    private String fromTime;
    private String toTime;

}
