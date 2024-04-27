package com.BusReservation.payload;


import lombok.Data;

@Data
public class DriverDto {

    private long driverId;
    private String driverName;
    private String licenseNumber;
    private String adharNumber;
    private String address;
    private String contactNumber;
    private String alternateContactNumber;
    private String emailId;

    private byte[] profilePicture;

}
