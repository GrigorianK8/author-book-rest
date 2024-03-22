package com.example.authorbookrest.mapper;

import com.example.authorbookrest.dto.BookDto;
import com.example.authorbookrest.dto.SaveBookDto;
import com.example.authorbookrest.entity.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;


@Mapper(componentModel = "spring")
public interface BookMapper {

    @Mapping(target = "authorResponseDto", source = "author")
    BookDto map(Book book);

    Book map(SaveBookDto saveBookDto);

    List<BookDto> map(List<Book> books);
}
