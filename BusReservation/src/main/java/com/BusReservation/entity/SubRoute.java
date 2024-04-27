package com.BusReservation.entity;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "subroute_table")
public class SubRoute {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long subRouteId;
    private String fromLocation;
    private String toLocation;
    private String fromDate;
    private String toDate;
    private String fromTime;
    private String toTime;

    @JoinColumn(name = "route_id", unique = true)
    private Long routeId;

}
