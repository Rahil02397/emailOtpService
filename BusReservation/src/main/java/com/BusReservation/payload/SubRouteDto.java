package com.BusReservation.payload;

import com.BusReservation.entity.Route;
import lombok.Data;

import java.util.List;

@Data
public class SubRouteDto {

    private Long subRouteId;
    private String fromLocation;
    private String toLocation;
    private String fromDate;
    private String toDate;
    private String fromTime;
    private String toTime;
    private Long routeId;
}
