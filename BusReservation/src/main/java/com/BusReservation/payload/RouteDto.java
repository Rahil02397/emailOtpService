package com.BusReservation.payload;

import lombok.Data;
@Data
public class RouteDto {

    private Long routeId;
    private String fromLocation;
    private String toLocation;
    private String fromDate;
    private String toDate;
    private String fromTime;
    private String toTime;
    private Long busId;
}
