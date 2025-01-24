package com.test.librarySystem.utils;

import com.test.librarySystem.dtos.request.BookDTO;
import com.test.librarySystem.entities.Book;

public class ConvertBook {
    public static BookDTO bookToBookDTO(Book book) {
        return new BookDTO(
                book.getTitle(),
                book.getAuthor(),
                book.getPublishedDate(),
                book.getIsbn()
        );
    }

    public static Book bookDTOToBook(BookDTO book) {
        return new Book(
                book.title(),
                book.author(),
                book.publishedDate(),
                book.isbn()
        );
    }
}
