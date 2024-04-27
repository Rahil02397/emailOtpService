package com.BusReservation.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="passenger_table")
public class Passenger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private Long contactNumber;
    private String email;
    private String dob;

    @JoinColumn(name = "busId",unique = true)
    private Long busId;

    @JoinColumn(name = "routeId", unique = true)
    private Long routeId;
}
