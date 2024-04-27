package com.BusReservation.service.ServiceImpl;

import com.BusReservation.entity.Driver;
import com.BusReservation.payload.DriverDto;
import com.BusReservation.repository.DriverRepository;
import com.BusReservation.service.DriverService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class DriverServiceImpl implements DriverService {
    private ModelMapper modelMapper;
    private DriverRepository driverRepository;
    public DriverServiceImpl(ModelMapper modelMapper, DriverRepository driverRepository) {
        this.modelMapper = modelMapper;
        this.driverRepository = driverRepository;
    }

    @Override
    public String addDriver(DriverDto driverDto) {
        Driver driver = mapToEntity(driverDto);
        if(driver != null){
        driverRepository.save(driver);
        return "Driver saved successfully";
    }else {
            return "Please check details proplerly!";
        }
    }

    @Override
    public String deleteDriver(long driverId) {
        Optional<Driver> driver = driverRepository.findById(driverId);
        if(driver.isPresent()){
            driverRepository.deleteById(driverId);
            return "Driver deleted successfully";
        }
            return "Driver not found";
    }

    Driver mapToEntity(DriverDto driverDto) {
        return modelMapper.map(driverDto, Driver.class);
    }

}
