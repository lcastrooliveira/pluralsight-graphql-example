package com.lcastrooliveira.graphqlpluralsightdemo.repositories;

import com.lcastrooliveira.graphqlpluralsightdemo.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {}
