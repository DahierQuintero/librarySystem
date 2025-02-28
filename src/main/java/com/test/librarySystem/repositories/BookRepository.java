package com.test.librarySystem.repositories;

import com.test.librarySystem.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    Optional<Book> findByIsbn (String isbn);
    boolean existsByIsbn(String isbn);
}
