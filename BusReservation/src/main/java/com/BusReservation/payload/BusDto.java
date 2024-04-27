package com.BusReservation.payload;
import com.BusReservation.entity.Driver;
import lombok.Data;

import java.util.List;

@Data

public class BusDto {
    private Long busId;
    private String number;
    private String type;
    private String price;
    private int totalSeats;
    private int availableSeats;
    private Long driverId;
    private RouteDto route;
    private List<SubRouteDto> subRoutes;
}
