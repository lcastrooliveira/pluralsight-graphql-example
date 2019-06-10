package com.lcastrooliveira.graphqlpluralsightdemo.resolvers;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.lcastrooliveira.graphqlpluralsightdemo.errors.exceptions.BookNotFoundException;
import com.lcastrooliveira.graphqlpluralsightdemo.model.Author;
import com.lcastrooliveira.graphqlpluralsightdemo.model.Book;
import com.lcastrooliveira.graphqlpluralsightdemo.repositories.AuthorRepository;
import com.lcastrooliveira.graphqlpluralsightdemo.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Mutation implements GraphQLMutationResolver {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    @Autowired
    public Mutation(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    public Author newAuthor(String firstName, String lastName) {
        Author author = new Author();
        author.setFirstName(firstName);
        author.setLastName(lastName);
        authorRepository.save(author);
        return author;
    }

    public Book newBook(String title, String isbn, Integer pageCount, Long authorId) {
        Book book = new Book();
        book.setAuthor(new Author(authorId));
        book.setTitle(title);
        book.setIsbn(isbn);
        book.setPageCount(pageCount != null ? pageCount : 0);

        bookRepository.save(book);

        return book;
    }

    public boolean deleteBook(Long id) {
        bookRepository.deleteById(id);
        return true;
    }

    public Book updateBookPageCount(Integer pageCount, Long id) {
        final Optional<Book> bookOptional = bookRepository.findById(id);
        return bookOptional.map(book -> {
            book.setPageCount(pageCount);
            bookRepository.save(book);
            return book;
        }).orElseThrow(() -> new BookNotFoundException("The book to be updated was not found", id));
    }
}
