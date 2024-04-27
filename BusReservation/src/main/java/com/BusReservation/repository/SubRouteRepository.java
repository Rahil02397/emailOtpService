package com.BusReservation.repository;

import com.BusReservation.entity.SubRoute;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubRouteRepository extends JpaRepository<SubRoute, Long> {
    List<SubRoute> findByFromLocationAndToLocationAndFromDate(String fromLocation, String toLocation, String fromDate);
}
