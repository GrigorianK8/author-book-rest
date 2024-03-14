package com.example.authorbookrest.endpoint;

import com.example.authorbookrest.dto.BookDto;
import com.example.authorbookrest.dto.SaveBookDto;
import com.example.authorbookrest.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("v1/books")
public class BookEndpoint {

    private final BookService bookService;

    public BookDto create(@RequestBody SaveBookDto saveBookDto) {
        return bookService.save(saveBookDto);
    }
}
