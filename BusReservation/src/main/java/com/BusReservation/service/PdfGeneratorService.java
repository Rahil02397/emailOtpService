package com.BusReservation.service;

import com.BusReservation.entity.Passenger;

public interface PdfGeneratorService {
    void generatePdf(Passenger passenger);
}
