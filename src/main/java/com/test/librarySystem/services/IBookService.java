package com.test.librarySystem.services;

import com.test.librarySystem.dtos.request.BookDTO;
import com.test.librarySystem.dtos.request.UpdateBookDTO;
import com.test.librarySystem.dtos.response.BookDetailsDTO;
import com.test.librarySystem.dtos.response.SimpleMessageResponse;

import java.util.List;

public interface IBookService {

    BookDetailsDTO create(BookDTO book);
    BookDetailsDTO getBookById(Long id);
    BookDetailsDTO update(Long id, UpdateBookDTO updateBook);
    SimpleMessageResponse delete(Long id);
    List<BookDetailsDTO> getAllBooks();

}
