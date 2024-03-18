package com.example.authorbookrest.service;

import com.example.authorbookrest.dto.BookDto;
import com.example.authorbookrest.dto.SaveBookDto;

import java.util.List;

public interface BookService {
    BookDto save(SaveBookDto saveBookDto);

    List<BookDto> getAll();
}
