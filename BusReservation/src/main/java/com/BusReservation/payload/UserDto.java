package com.BusReservation.payload;

import lombok.Data;

@Data
public class UserDto {
    private String userId;
    private String userName;
    private String emailId;
    private String password;

    private byte[] profilePicture;

}
