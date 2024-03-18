package com.example.authorbookrest.endpoint;

import com.example.authorbookrest.dto.BookDto;
import com.example.authorbookrest.dto.SaveBookDto;
import com.example.authorbookrest.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("v1/books")
public class BookEndpoint {

    private final BookService bookService;

    @PostMapping()
    public BookDto create(@RequestBody SaveBookDto saveBookDto) {
        return bookService.save(saveBookDto);
    }

    @GetMapping
    public List<BookDto> getAll() {
        return bookService.getAll();
    }

}
