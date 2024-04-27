package com.BusReservation.service.ServiceImpl;

import com.BusReservation.entity.Bus;
import com.BusReservation.entity.Route;
import com.BusReservation.exception.BusNotFoundException;
import com.BusReservation.exception.RouteNotFoundException;
import com.BusReservation.payload.BusDto;
import com.BusReservation.payload.RouteDto;
import com.BusReservation.payload.SubRouteDto;
import com.BusReservation.repository.BusRepository;
import com.BusReservation.service.BusService;

import com.BusReservation.service.RouteService;
import com.BusReservation.service.SubRouteService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class BusServiceImpl implements BusService {

    private BusRepository busRepository;
    private RouteService routeService;
    private ModelMapper modelMapper;
    private SubRouteService subRouteService;
    public BusServiceImpl(BusRepository busRepository, RouteService routeService, ModelMapper modelMapper, SubRouteService subRouteService) {
        this.busRepository = busRepository;
        this.routeService = routeService;
        this.subRouteService = subRouteService;
        this.modelMapper = modelMapper;
    }
    @Override
    public String addBus(BusDto busDto) {
        Bus bus = mapToEntity(busDto);
        busRepository.save(bus);
        return "Bus saved successfully!!!";
    }

    @Override
    public List<BusDto> searchBus(String fromLocation, String toLocation, String fromDate) throws RouteNotFoundException{
        RouteDto routeDto = routeService.searchRoute(fromLocation, toLocation, fromDate);
        List<SubRouteDto> subRouteDtos = subRouteService.searchSubRoute(fromLocation, toLocation, fromDate);
            Optional<Bus> busId = busRepository.findById(routeDto.getBusId());
            if (busId.isPresent()) {
                Bus bus = busId.get();
                BusDto busDto = mapToDto(bus);
                busDto.setSubRoutes(subRouteDtos);
                busDto.setRoute(routeDto);
                List<BusDto> buses = new ArrayList<>();
                buses.add(busDto);
                return buses;
            } else {
               throw new BusNotFoundException("No Bus available on this route");
            }
    }


    @Override
    public String deleteBusById(long busId) {
        Optional<Bus> bus = busRepository.findById(busId);
        if(bus.isPresent()){
           busRepository.deleteById(busId);
           return "Bus deleted successfully";
        }else {
            throw new BusNotFoundException("Bus with id=" + busId + "is not availabe");
        }
    }



    Bus mapToEntity(BusDto busDto) {
       return modelMapper.map(busDto, Bus.class);
    }
    Route mapToEntity(RouteDto routeDto){
        return modelMapper.map(routeDto, Route.class);
    }
    BusDto mapToDto(Bus bus) {
        return modelMapper.map(bus, BusDto.class);
    }
}


