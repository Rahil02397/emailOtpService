package com.iCare.Signup;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.Email;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name="user_data")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name ="first_name", nullable=false,length=100)
    private String firstName;
    @Column(name ="last_name", nullable=false,length=100)
    private String lastName;
    @Column(name ="user_name", nullable=false,unique=true,length=100)
    private String userName;
    @Email
    @Column(name ="email", nullable=false,unique=true ,length=100)
    private String email;
    @Column(name = "password",nullable=false)
    private String password;
}
