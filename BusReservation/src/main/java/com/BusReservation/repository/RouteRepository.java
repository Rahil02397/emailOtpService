package com.BusReservation.repository;

import com.BusReservation.entity.Route;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RouteRepository extends JpaRepository<Route, Long> {
   Route findByFromLocationAndToLocationAndFromDate(String fromLocation, String toLocation, String fromDate);

}
