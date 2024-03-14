package com.example.authorbookrest.service.impl;

import com.example.authorbookrest.dto.BookDto;
import com.example.authorbookrest.dto.SaveBookDto;
import com.example.authorbookrest.entity.Book;
import com.example.authorbookrest.mapper.BookMapper;
import com.example.authorbookrest.repository.AuthorRepository;
import com.example.authorbookrest.repository.BookRepository;
import com.example.authorbookrest.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;
    private final AuthorRepository authorRepository;

    @Override
    public BookDto save(SaveBookDto saveBookDto) {
        Book book = bookMapper.map(saveBookDto);
        book.setAuthor(authorRepository.findById(saveBookDto.getAuthorId()).orElse(null));
        bookRepository.save(book);
        return bookMapper.map(book);
    }
}
