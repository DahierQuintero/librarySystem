package com.test.librarySystem.controllers;

import com.test.librarySystem.dtos.request.BookDTO;
import com.test.librarySystem.dtos.request.UpdateBookDTO;
import com.test.librarySystem.dtos.response.BookDetailsDTO;
import com.test.librarySystem.dtos.response.SimpleMessageResponse;
import com.test.librarySystem.services.impl.BookServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookServiceImpl bookService;

    public BookController(BookServiceImpl bookService) {
        this.bookService = bookService;
    }

    @PostMapping()
    public ResponseEntity<?> create(@RequestBody BookDTO book) {
        return bookService.create(book);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getBookById(@PathVariable Long id) {
        return bookService.getBookById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody UpdateBookDTO updateBook) {
        return bookService.update(id, updateBook);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return bookService.delete(id);
    }

    @GetMapping()
    public ResponseEntity<?> getAllBooks() {
        return bookService.getAllBooks();
    }
}
