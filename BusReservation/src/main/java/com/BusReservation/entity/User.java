package com.BusReservation.entity;

import javax.persistence.*;
import javax.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="user_registration")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String userName;
    private String emailId;
    private String password;

    @Lob
    @Column(name="profile_picture", length = 1024)
    private byte[] profilePicture;

}
