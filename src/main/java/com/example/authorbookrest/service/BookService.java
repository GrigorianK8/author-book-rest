package com.example.authorbookrest.service;

import com.example.authorbookrest.dto.BookDto;
import com.example.authorbookrest.dto.SaveBookDto;

public interface BookService {
    BookDto save(SaveBookDto saveBookDto);
}
