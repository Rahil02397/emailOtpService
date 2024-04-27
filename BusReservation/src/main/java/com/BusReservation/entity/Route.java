package com.BusReservation.entity;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "route_table")
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long routeId;
    private String fromLocation;
    private String toLocation;
    private String fromDate;
    private String toDate;
    private String fromTime;
    private String toTime;

    @JoinColumn(name = "bus_id", unique=true)
    private Long busId;


    // Constructors, getters, and setters
}
