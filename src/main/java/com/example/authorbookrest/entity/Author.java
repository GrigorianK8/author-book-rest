package com.example.authorbookrest.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "author")
@Data
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private int age;
}
