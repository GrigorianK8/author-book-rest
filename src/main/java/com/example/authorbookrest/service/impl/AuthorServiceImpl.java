package com.example.authorbookrest.service.impl;

import com.example.authorbookrest.dto.AuthorResponseDto;
import com.example.authorbookrest.dto.PagingResponseDto;
import com.example.authorbookrest.dto.SaveAuthorDto;
import com.example.authorbookrest.entity.Author;
import com.example.authorbookrest.mapper.AuthorMapper;
import com.example.authorbookrest.repository.AuthorRepository;
import com.example.authorbookrest.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;
    private final AuthorMapper authorMapper;

    @Override
    public AuthorResponseDto create(SaveAuthorDto saveAuthorDto) {
        Author authorEntity = authorMapper.map(saveAuthorDto);
        return authorMapper.map(authorRepository.save(
                authorEntity)
        );
    }

    @Override
    public PagingResponseDto getAll(Pageable pageable) {
        Page<Author> all = authorRepository.findAll(pageable);
        List<AuthorResponseDto> authorResponseDtos = new ArrayList<>();
        for (Author author : all.getContent()) {
            authorResponseDtos.add(authorMapper.map(author));
        }
        return PagingResponseDto.builder()
                .data( authorResponseDtos)
                .totalElements(all.getTotalElements())
                .size(all.getSize())
                .page(all.getPageable().getPageNumber())
                .build();
    }

    @Override
    public AuthorResponseDto getById(int id) {
        Author author = authorRepository.findById(id)
                .orElse(null);
        if (author == null) {
            return null;
        }
        return authorMapper.map(author);
    }

    @Override
    public AuthorResponseDto update(int id, SaveAuthorDto author) {
        Author savedAuthor = authorMapper.map(author);
        savedAuthor.setId(id);
        authorRepository.save(savedAuthor);

        return authorMapper.map(savedAuthor);
    }

    @Override
    public void deleteById(int id) {
        authorRepository.deleteById(id);
    }
}
