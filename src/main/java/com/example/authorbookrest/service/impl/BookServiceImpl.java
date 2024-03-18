package com.example.authorbookrest.service.impl;

import com.example.authorbookrest.dto.BookDto;
import com.example.authorbookrest.dto.CBCurrencyResponseDto;
import com.example.authorbookrest.dto.SaveBookDto;
import com.example.authorbookrest.entity.Book;
import com.example.authorbookrest.mapper.BookMapper;
import com.example.authorbookrest.repository.AuthorRepository;
import com.example.authorbookrest.repository.BookRepository;
import com.example.authorbookrest.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;
    private final AuthorRepository authorRepository;
    private final RestTemplate restTemplate;

    @Override
    public BookDto save(SaveBookDto saveBookDto) {
        Book book = bookMapper.map(saveBookDto);
        book.setAuthor(authorRepository.findById(saveBookDto.getAuthorId()).orElse(null));
        bookRepository.save(book);
        return bookMapper.map(book);
    }

    @Override
    public List<BookDto> getAll() {
        List<Book> all = bookRepository.findAll();
        List<BookDto> bookDtos = new ArrayList<>();
        double usdCurrency = getUsdCurrency();
        if (!all.isEmpty()) {
            for (Book book : all) {
                BookDto bookDto = bookMapper.map(book);
                setUsdPrice(bookDto, usdCurrency);
                bookDtos.add(bookDto);
            }
        }

        return bookDtos;
    }

    private void setUsdPrice(BookDto bookDto, double usdCurrency) {
        bookDto.setPriceUSD(bookDto.getPrice() / usdCurrency);
    }

    private double getUsdCurrency() {
        ResponseEntity<CBCurrencyResponseDto> forEntity = restTemplate
                .getForEntity("https://cb.am/latest.json.php?currency=USD",
                        CBCurrencyResponseDto.class);
        if (forEntity.getStatusCode() == HttpStatusCode.valueOf(200)) {
            CBCurrencyResponseDto body = forEntity.getBody();
            return Double.parseDouble(body.getUsd());
        }
        return 0;
    }
}
