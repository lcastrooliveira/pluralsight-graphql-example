package com.lcastrooliveira.graphqlpluralsightdemo.repositories;

import com.lcastrooliveira.graphqlpluralsightdemo.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {}
