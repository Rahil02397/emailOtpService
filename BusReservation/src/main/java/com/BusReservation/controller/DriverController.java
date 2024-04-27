package com.BusReservation.controller;


import com.BusReservation.payload.DriverDto;
import com.BusReservation.service.DriverService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/driver")
public class DriverController {
    private DriverService driverService;

    public DriverController(DriverService driverService) {
        this.driverService = driverService;
    }

    @PostMapping("/add-driver")
    public ResponseEntity<String> addDriver(
            @RequestParam("profilePicture") MultipartFile profilePicture,
            @RequestParam("driverId") long driverId,
            @RequestParam("driverName") String driverName,
            @RequestParam("licenseNumber") String licenseNumber,
            @RequestParam("adharNumber") String adharNumber,
            @RequestParam("address") String address,
            @RequestParam("contactNumber") String contactNumber,
            @RequestParam("emailId") String emailId,
            @RequestParam("alternateContactNumber") String alternateContactNumber) throws IOException {
        DriverDto driverDto = new DriverDto();
        driverDto.setDriverId(driverId);
        driverDto.setDriverName(driverName);
        driverDto.setLicenseNumber(licenseNumber);
        driverDto.setAdharNumber(adharNumber);
        driverDto.setAddress(address);
        driverDto.setContactNumber(contactNumber);
        driverDto.setAlternateContactNumber(alternateContactNumber);
        driverDto.setEmailId(emailId);
        driverDto.setProfilePicture(profilePicture.getBytes());
        String message = driverService.addDriver(driverDto);
        return  new ResponseEntity<>(message, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete-mapping")
    public ResponseEntity<?> deleteDriver(@RequestParam long driverId){
        String message = driverService.deleteDriver(driverId);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}
