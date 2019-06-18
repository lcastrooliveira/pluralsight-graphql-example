package com.lcastrooliveira.graphqlpluralsightdemo.controllers;

import com.lcastrooliveira.graphqlpluralsightdemo.model.Book;
import com.lcastrooliveira.graphqlpluralsightdemo.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/books")
public class BooksController {

    private final BookRepository bookRepository;

    @Autowired
    public BooksController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping
    public ResponseEntity<Page<Book>> all(Pageable pageable) {
        return ResponseEntity.ok(bookRepository.findAll(pageable));
    }
}
