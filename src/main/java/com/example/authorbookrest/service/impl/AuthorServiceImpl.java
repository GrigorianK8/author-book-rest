package com.example.authorbookrest.service.impl;

import com.example.authorbookrest.dto.AuthorResponseDto;
import com.example.authorbookrest.dto.SaveAuthorDto;
import com.example.authorbookrest.entity.Author;
import com.example.authorbookrest.repository.AuthorRepository;
import com.example.authorbookrest.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    @Override
    public AuthorResponseDto create(SaveAuthorDto author) {
        Author savedAuthor = authorRepository.save(Author.builder()
                .name(author.getName())
                .surname(author.getSurname())
                .age(author.getAge())
                .gender(author.getGender())
                .build());

        return AuthorResponseDto.builder()
                .id(savedAuthor.getId())
                .name(savedAuthor.getName())
                .surname(savedAuthor.getSurname())
                .age(savedAuthor.getAge())
                .gender(savedAuthor.getGender())
                .build();
    }

    @Override
    public List<AuthorResponseDto> getAll() {
        List<Author> all = authorRepository.findAll();
        List<AuthorResponseDto> authorResponseDtos = new ArrayList<>();
        for (Author author : all) {
            authorResponseDtos.add(AuthorResponseDto.builder()
                    .id(author.getId())
                    .name(author.getName())
                    .surname(author.getSurname())
                    .age(author.getAge())
                    .gender(author.getGender())
                    .build());
        }
        return authorResponseDtos;
    }

    @Override
    public AuthorResponseDto getById(int id) {
        Author author = authorRepository.findById(id)
                .orElse(null);
        if (author == null) {
            return null;
        }
        return AuthorResponseDto.builder()
                .id(author.getId())
                .name(author.getName())
                .surname(author.getSurname())
                .age(author.getAge())
                .gender(author.getGender())
                .build();
    }

    @Override
    public AuthorResponseDto update(int id, SaveAuthorDto author) {
        Author savedAuthor = authorRepository.save(Author.builder()
                .id(id)
                .name(author.getName())
                .surname(author.getSurname())
                .age(author.getAge())
                .gender(author.getGender())
                .build());
        return AuthorResponseDto.builder()
                .id(savedAuthor.getId())
                .name(savedAuthor.getName())
                .surname(savedAuthor.getSurname())
                .age(savedAuthor.getAge())
                .gender(savedAuthor.getGender())
                .build();
    }

    @Override
    public void deleteById(int id) {
        authorRepository.deleteById(id);
    }
}
