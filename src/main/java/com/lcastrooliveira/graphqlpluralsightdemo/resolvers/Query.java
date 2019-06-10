package com.lcastrooliveira.graphqlpluralsightdemo.resolvers;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.lcastrooliveira.graphqlpluralsightdemo.model.Author;
import com.lcastrooliveira.graphqlpluralsightdemo.model.Book;
import com.lcastrooliveira.graphqlpluralsightdemo.repositories.AuthorRepository;
import com.lcastrooliveira.graphqlpluralsightdemo.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Query implements GraphQLQueryResolver {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    @Autowired
    public Query(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    public Iterable<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    public Iterable<Author> findAllAuthors() {
        return authorRepository.findAll();
    }

    public long countBooks() {
        return bookRepository.count();
    }

    public long countAuthors() {
        return authorRepository.count();
    }
}
