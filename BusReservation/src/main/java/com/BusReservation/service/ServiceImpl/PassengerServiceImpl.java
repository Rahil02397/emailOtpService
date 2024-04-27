package com.BusReservation.service.ServiceImpl;

import com.BusReservation.entity.Bus;
import com.BusReservation.entity.Passenger;
import com.BusReservation.entity.Route;
import com.BusReservation.exception.BusNotFoundException;
import com.BusReservation.exception.RouteNotFoundException;
import com.BusReservation.payload.PassengerDto;
import com.BusReservation.repository.BusRepository;
import com.BusReservation.repository.PassengerRepository;
import com.BusReservation.repository.RouteRepository;
import com.BusReservation.service.PassengerService;
import com.BusReservation.service.PdfGeneratorService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PassengerServiceImpl implements PassengerService {
    private BusRepository busRepository;
    private RouteRepository routeRepository;
    private PassengerRepository passengerRepository;
    private ModelMapper modelMapper;
    private PdfGeneratorService pdfGeneratorService;

    public PassengerServiceImpl(BusRepository busRepository, RouteRepository routeRepository, PassengerRepository passengerRepository, ModelMapper modelMapper, PdfGeneratorService pdfGeneratorService) {
        this.busRepository = busRepository;
        this.routeRepository = routeRepository;
        this.passengerRepository = passengerRepository;
        this.modelMapper = modelMapper;
        this.pdfGeneratorService = pdfGeneratorService;
    }

    @Override
    public PassengerDto bookBus(Long busId, Long routeId, Passenger passenger) {

        Optional<Bus> exBus = busRepository.findById(busId);
        if (exBus.isPresent()) {
            Bus bus = exBus.get();

            Optional<Route> exRoute = routeRepository.findById(routeId);
            if (exRoute.isPresent()) {
                Route route = exRoute.get();
                passenger.setBusId(busId);
                passenger.setRouteId(routeId);
                Passenger savedPassenger = passengerRepository.save(passenger);

                PassengerDto passengerDto = maptoDto(savedPassenger);
                passengerDto.setNumber(bus.getNumber());
                passengerDto.setType(bus.getType());
                passengerDto.setAvailableSeats(bus.getAvailableSeats());
                passengerDto.setTotalSeats(bus.getTotalSeats());
                passengerDto.setPrice(bus.getPrice());
                passengerDto.setFromLocation(route.getFromLocation());
                passengerDto.setToLocation(route.getToLocation());
                passengerDto.setFromDate(route.getFromDate());
                passengerDto.setToDate(route.getToDate());
                passengerDto.setFromTime(route.getFromTime());
                passengerDto.setToTime(route.getToTime());
                pdfGeneratorService.generatePdf(passenger);
                return passengerDto;
            }else{
                throw new RouteNotFoundException("Route Not Found");
            }
        }else{
            throw new BusNotFoundException("Bus Not Found");
        }

    }

    PassengerDto maptoDto(Passenger savedPassenger) {
        return modelMapper.map(savedPassenger,PassengerDto.class);
    }
}
