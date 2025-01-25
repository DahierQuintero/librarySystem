package com.test.librarySystem.controllers;

import com.test.librarySystem.dtos.request.BookDTO;
import com.test.librarySystem.dtos.request.UpdateBookDTO;
import com.test.librarySystem.dtos.response.BookDetailsDTO;
import com.test.librarySystem.dtos.response.SimpleMessageResponse;
import com.test.librarySystem.services.impl.BookServiceImpl;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<BookDetailsDTO> create(@Valid @RequestBody BookDTO book) {
        return new ResponseEntity<>(bookService.create(book), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public BookDetailsDTO getBookById(@PathVariable Long id) {
        return bookService.getBookById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookDetailsDTO> update(@PathVariable Long id, @RequestBody UpdateBookDTO updateBook) {
        return new ResponseEntity<>(bookService.update(id, updateBook), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public SimpleMessageResponse delete(@PathVariable Long id) {
        return bookService.delete(id);
    }

    @GetMapping()
    public List<BookDetailsDTO> getAllBooks() {
        return bookService.getAllBooks();
    }
}
