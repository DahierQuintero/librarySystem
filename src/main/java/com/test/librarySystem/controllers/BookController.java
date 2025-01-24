package com.test.librarySystem.controllers;

import com.test.librarySystem.dtos.request.BookDTO;
import com.test.librarySystem.dtos.request.UpdateBookDTO;
import com.test.librarySystem.dtos.response.BookDetailsDTO;
import com.test.librarySystem.services.impl.BookServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookServiceImpl bookService;

    public BookController(BookServiceImpl bookService) {
        this.bookService = bookService;
    }

    @PostMapping()
    public BookDetailsDTO create (@RequestBody BookDTO book) {
        return bookService.create(book);
    }

    @GetMapping("/{id}")
    public BookDetailsDTO getBookById(@PathVariable Long id) {
        return bookService.getBookById(id);
    }

    @PutMapping("/{id}")
    public BookDetailsDTO update(@PathVariable Long id, @RequestBody UpdateBookDTO updateBook) {
        return bookService.update(id, updateBook);
    }

}
