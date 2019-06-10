package com.lcastrooliveira.graphqlpluralsightdemo;

import com.lcastrooliveira.graphqlpluralsightdemo.model.Author;
import com.lcastrooliveira.graphqlpluralsightdemo.model.Book;
import com.lcastrooliveira.graphqlpluralsightdemo.repositories.AuthorRepository;
import com.lcastrooliveira.graphqlpluralsightdemo.repositories.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GraphqlPluralsightDemoApplication {

    private static Logger LOG = LoggerFactory
            .getLogger(GraphqlPluralsightDemoApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(GraphqlPluralsightDemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(AuthorRepository authorRepository, BookRepository bookRepository) {
        return (args) -> {
            Author author = new Author("Herbert", "Schildt");
            authorRepository.save(author);

            bookRepository.save(new Book("Java: A Beginner's Guide, Sixth Edition", "0071809252", 728, author));
        };
    }
}
