package com.BusReservation.entity;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="bus_table")
public class Bus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long busId;
    private String number;
    private String type;
    private Double price;
    private int totalSeats;
    private int availableSeats;

    @JoinColumn(name = "driver_id" ,unique=true)
    private Long driverId;

    @Lob
    @Column(name="profile_picture", length = 1024)
    private byte[] profilePicture;



}
