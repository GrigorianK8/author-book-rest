package com.example.authorbookrest.service.impl;

import com.example.authorbookrest.repository.BookRepository;
import com.example.authorbookrest.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
}
