package com.example.authorbookrest.mapper;

import com.example.authorbookrest.dto.AuthorResponseDto;
import com.example.authorbookrest.dto.SaveAuthorDto;
import com.example.authorbookrest.entity.Author;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AuthorMapper {

    @Mapping(target = "firstName", source = "name")
    AuthorResponseDto map(Author author);

    @Mapping(target = "createdDate", expression = "Java(java.time.localDate.now())")
    Author map(SaveAuthorDto saveAuthorDto);
}
