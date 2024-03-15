package com.example.authorbookrest.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "user")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String surname;
    private String email;
    private String password;
    private String imagePath;

    @Enumerated(EnumType.STRING)
    private UserType userType;
}
