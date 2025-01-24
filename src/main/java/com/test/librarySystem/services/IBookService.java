package com.test.librarySystem.services;

import com.test.librarySystem.dtos.request.BookDTO;
import com.test.librarySystem.dtos.request.UpdateBookDTO;
import com.test.librarySystem.dtos.response.BookDetailsDTO;

public interface IBookService {

    BookDetailsDTO create(BookDTO book);
    BookDetailsDTO getBookById(Long id);
    BookDetailsDTO update(Long id, UpdateBookDTO updateBook);

}
