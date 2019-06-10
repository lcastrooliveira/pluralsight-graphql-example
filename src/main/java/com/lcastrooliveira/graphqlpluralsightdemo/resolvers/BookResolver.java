package com.lcastrooliveira.graphqlpluralsightdemo.resolvers;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.lcastrooliveira.graphqlpluralsightdemo.model.Author;
import com.lcastrooliveira.graphqlpluralsightdemo.model.Book;
import com.lcastrooliveira.graphqlpluralsightdemo.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookResolver implements GraphQLResolver<Book> {

    private final AuthorRepository authorRepository;

    @Autowired
    public BookResolver(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Author getAuthor(Book book) {
        return authorRepository.findById(book.getAuthor().getId()).get();
    }
}
