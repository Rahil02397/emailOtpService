package com.BusReservation.entity;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name="driver_table")
public class Driver {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long driverId;
    private String driverName;
    private String licenseNumber;
    private Long adharNumber;
    private String address;
    private Long contactNumber;
    private Long alternateContactNumber;
    private String emailId;
    @Lob
    @Column(name="profile_picture", columnDefinition = "BLOB")
    private byte[] profilePicture;


}
