package com.example.authorbookrest.endpoint;

import com.example.authorbookrest.entity.Author;
import com.example.authorbookrest.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("v1/authors")
public class AuthorEndpoint {

    private final AuthorService authorService;

    @PostMapping
    public Author createAuthor(@RequestBody Author author) {
        return authorService.create(author);
    }

    @GetMapping
    public List<Author> getAll() {
        return authorService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Author> getById(@PathVariable("id") int id) {
        Author author = authorService.getById(id);
        if (author == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(author);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Author> update(@PathVariable("id") int id, @RequestBody Author author) {
        Author byId = authorService.getById(id);
        if (byId == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(authorService.update(id, author));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Author> delteById(@PathVariable("id") int id) {
        Author byId = authorService.getById(id);
        if (byId == null) {
            return ResponseEntity.notFound().build();
        }
        authorService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}

