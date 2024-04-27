package com.BusReservation.service.ServiceImpl;

import com.BusReservation.entity.Route;
import com.BusReservation.exception.RouteNotFoundException;
import com.BusReservation.payload.RouteDto;
import com.BusReservation.repository.RouteRepository;
import com.BusReservation.service.RouteService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class RouteServiceImpl implements RouteService {
    private RouteRepository routeRepository;
    private ModelMapper modelMapper;

    public RouteServiceImpl(RouteRepository routeRepository, ModelMapper modelMapper) {
        this.routeRepository = routeRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public String addRoute(RouteDto routeDto) {
        Route route = mapToEntity(routeDto);
        if(route != null){
            routeRepository.save(route);
            return "Route saved successfully!!";
        }
        return "An Error Occurred";
    }

    @Override
    public RouteDto searchRoute(String fromLocation, String toLocation, String fromDate) {
        Route route = routeRepository.findByFromLocationAndToLocationAndFromDate(fromLocation, toLocation, fromDate);
        if (route != null) {
            return mapToDto(route);
        } else {
            throw new RouteNotFoundException("Route Not Found");
        }
    }

    RouteDto  mapToDto(Route route) {
        return modelMapper.map(route,RouteDto.class);
    }

    Route mapToEntity(RouteDto routeDto) {
       return modelMapper.map(routeDto, Route.class);
    }
}
