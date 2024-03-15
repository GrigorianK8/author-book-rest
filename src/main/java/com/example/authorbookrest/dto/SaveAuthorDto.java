package com.example.authorbookrest.dto;


import com.example.authorbookrest.entity.Gender;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SaveAuthorDto {

    @JsonProperty("name")
    private String name;

    private String surname;
    private Gender gender;
    private int age;
}
