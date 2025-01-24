package com.test.librarySystem.services;

import com.test.librarySystem.dtos.request.BookDTO;
import com.test.librarySystem.dtos.request.UpdateBookDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IBookService {

    ResponseEntity<?> create(BookDTO book);
    ResponseEntity<?> getBookById(Long id);
    ResponseEntity<?> update(Long id, UpdateBookDTO updateBook);
    ResponseEntity<?> delete( Long id);
    ResponseEntity<?> getAllBooks();

}
