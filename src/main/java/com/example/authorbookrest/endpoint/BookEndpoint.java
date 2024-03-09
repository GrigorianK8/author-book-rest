package com.example.authorbookrest.endpoint;

import com.example.authorbookrest.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BookEndpoint {

    private final BookService bookService;
}
