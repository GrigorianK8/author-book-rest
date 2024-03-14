package com.example.authorbookrest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookDto {

    private int id;
    private String description;
    private double price;
    private String title;
    private AuthorResponseDto authorResponseDto;
}
