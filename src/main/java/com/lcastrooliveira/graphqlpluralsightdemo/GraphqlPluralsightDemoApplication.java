package com.lcastrooliveira.graphqlpluralsightdemo;

import com.lcastrooliveira.graphqlpluralsightdemo.model.Address;
import com.lcastrooliveira.graphqlpluralsightdemo.model.Author;
import com.lcastrooliveira.graphqlpluralsightdemo.model.Book;
import com.lcastrooliveira.graphqlpluralsightdemo.repositories.AuthorRepository;
import com.lcastrooliveira.graphqlpluralsightdemo.repositories.BookRepository;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;

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
            final Author author1 = new Author("Herbert", "Schildt");
            author1.setDateOfBirth(LocalDate.now().minusYears(49));
            final Address address = createAddress("Brazil", "DF", "Brasilia");

            author1.setAddress(address);
            authorRepository.save(author1);

            final Author author2 = new Author("Erik", "Soares");
            author2.setDateOfBirth(LocalDate.now().minusYears(36));
            final Address address2 = createAddress("Brazil", "DF", "Ceilândia");
            author2.setAddress(address2);
            authorRepository.save(author2);

            Book javaBook = new Book("Java: A Beginner's Guide, Sixth Edition", "0071809252", 728, author1);
            javaBook.setDateOfRelease(LocalDate.of(1999, Month.JUNE, 24));
            javaBook.setNumberOfReviews(4000);
            javaBook.setStars(4.5);
            Book pythonBook = new Book("Python Cookbook", "0071809252", 123, author1);
            bookRepository.saveAll(Arrays.asList(javaBook, pythonBook));
        };
    }

    @NotNull
    private Address createAddress(String country, String state, String city) {
        final Address address = new Address();
        address.setCountry(country);
        address.setNeighbourhood("Centro");
        address.setState(state);
        address.setStreet("Rua A");
        address.setCity(city);
        return address;
    }
}
