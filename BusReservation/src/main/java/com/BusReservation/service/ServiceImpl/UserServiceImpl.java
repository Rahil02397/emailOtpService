package com.BusReservation.service.ServiceImpl;

import com.BusReservation.entity.User;
import com.BusReservation.payload.UserDto;
import com.BusReservation.repository.UserRepository;
import com.BusReservation.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public String createUser(UserDto userDto) {
        User user = mapToEntity(userDto);
        if(user != null){
        userRepository.save(user);
        return "User saved successfully!!";
    }
        return "Please check user details properly";
    }


    @Override
    public UserDto getUser(Long id) {
        Optional<User> exId = userRepository.findById(id);
        if(exId.isPresent()){
            User user = exId.get();
            return  mapToDto(user);
        }
        return null;
    }

   User mapToEntity(UserDto userDto) {
        return modelMapper.map(userDto, User.class);
    }

    UserDto mapToDto(User user){
        return modelMapper.map(user, UserDto.class);
    }
}
