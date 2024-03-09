package com.example.authorbookrest.service.impl;

import com.example.authorbookrest.entity.Author;
import com.example.authorbookrest.repository.AuthorRepository;
import com.example.authorbookrest.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    @Override
    public Author create(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public List<Author> getAll() {
        return authorRepository.findAll();
    }

    @Override
    public Author getById(int id) {
        return authorRepository.findById(id)
                .orElse(null);
    }

    @Override
    public Author update(int id, Author author) {
        author.setId(id);
        return authorRepository.save(author);
    }

    @Override
    public void deleteById(int id) {
        authorRepository.deleteById(id);
    }
}
