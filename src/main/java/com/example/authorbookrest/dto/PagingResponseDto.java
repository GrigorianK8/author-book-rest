package com.example.authorbookrest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PagingResponseDto {

    private Object data;
    private int size;
    private int page;
    private long totalElements;
}
