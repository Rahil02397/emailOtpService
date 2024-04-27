package com.BusReservation.repository;

import com.BusReservation.entity.Bus;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BusRepository extends JpaRepository<Bus,Long> {
}
