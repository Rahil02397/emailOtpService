package com.BusReservation.service.ServiceImpl;

import com.BusReservation.entity.SubRoute;
import com.BusReservation.exception.RouteNotFoundException;
import com.BusReservation.payload.SubRouteDto;
import com.BusReservation.repository.SubRouteRepository;
import com.BusReservation.service.SubRouteService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SubRouteServiceImpl implements SubRouteService {

    private SubRouteRepository subRouteRepository;
    private ModelMapper modelMapper;

    public SubRouteServiceImpl(SubRouteRepository subRouteRepository, ModelMapper modelMapper) {
        this.subRouteRepository = subRouteRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public String addSubRoute(SubRouteDto subRouteDto) {
        SubRoute subRoute = mapToEntity(subRouteDto);
        if (subRoute != null) {
            subRouteRepository.save(subRoute);
            return "Sub-route saved";
        }
        return "An Error Occurred!!";
    }

    @Override
    public List<SubRouteDto> searchSubRoute(String fromLocation, String toLocation, String fromDate) {
        List<SubRoute> subRoutes = subRouteRepository.findByFromLocationAndToLocationAndFromDate(fromLocation, toLocation, fromDate);
        if (subRoutes != null) {
            return subRoutes.stream()
                    .map(this::mapToDto)
                    .collect(Collectors.toList());
        } else {
            throw new RouteNotFoundException("Sub Route Not Found");
        }
    }

    SubRoute mapToEntity(SubRouteDto subRouteDto) {
        return modelMapper.map(subRouteDto, SubRoute.class);
    }
    SubRouteDto mapToDto(SubRoute subRoute){
        return modelMapper.map(subRoute, SubRouteDto.class);
    }

}
