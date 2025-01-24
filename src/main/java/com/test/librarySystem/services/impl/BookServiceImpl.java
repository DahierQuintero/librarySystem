package com.test.librarySystem.services.impl;

import com.test.librarySystem.dtos.request.BookDTO;
import com.test.librarySystem.dtos.request.UpdateBookDTO;
import com.test.librarySystem.dtos.response.BookDetailsDTO;
import com.test.librarySystem.dtos.response.SimpleMessageResponse;
import com.test.librarySystem.entities.Book;
import com.test.librarySystem.repositories.BookRepository;
import com.test.librarySystem.services.IBookService;
import com.test.librarySystem.utils.ConvertBook;
import com.test.librarySystem.utils.Status;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements IBookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public ResponseEntity<?> create(BookDTO book) {
        Book bookToSave = ConvertBook.bookDTOToBook(book);

        bookRepository.save(bookToSave);
        BookDetailsDTO bookDetailsDTO = new  BookDetailsDTO(
                                                bookToSave.getId(),
                                                bookToSave.getTitle(),
                                                bookToSave.getAuthor(),
                                                bookToSave.getPublishedDate(),
                                                bookToSave.getIsbn(),
                                                bookToSave.getStatus());

        return new ResponseEntity<>(bookDetailsDTO, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<?> getBookById(Long id) {
        Book bookFound = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book with id " + id + " does not exist"));
        BookDetailsDTO bookDetailsDTO = new BookDetailsDTO(
                                                bookFound.getId(),
                                                bookFound.getTitle(),
                                                bookFound.getAuthor(),
                                                bookFound.getPublishedDate(),
                                                bookFound.getIsbn(),
                                                bookFound.getStatus());

        return new ResponseEntity<>(bookDetailsDTO, HttpStatus.FOUND);
    }

    @Override
    public ResponseEntity<?> update(Long id, UpdateBookDTO updateBook) {
        Book bookFound = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book with id " + id + " does not exist"));

        bookFound.setTitle(updateBook.title());
        bookFound.setAuthor(updateBook.author());
        bookFound.setPublishedDate(updateBook.publishedDate());
        bookFound.setIsbn(updateBook.isbn());
        bookFound.setStatus(Status.stringToEnum(updateBook.status()));

        bookRepository.save(bookFound);

        BookDetailsDTO bookDetailsDTO = new BookDetailsDTO(
                                                bookFound.getId(),
                                                bookFound.getTitle(),
                                                bookFound.getAuthor(),
                                                bookFound.getPublishedDate(),
                                                bookFound.getIsbn(),
                                                bookFound.getStatus());

        return new ResponseEntity<>(bookDetailsDTO, HttpStatus.ACCEPTED);
    }

    @Override
    public ResponseEntity<?> delete(Long id) {
        Book bookFound = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book with id " + id + " does not exist"));

        bookRepository.deleteById(bookFound.getId());

        SimpleMessageResponse simpleMessageResponse = new SimpleMessageResponse("Book with id " + bookFound.getId() + " was successfully deleted");

        return new ResponseEntity<>(simpleMessageResponse, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getAllBooks() {
        List<Book> bookList = bookRepository.findAll();

        List<BookDetailsDTO> bookDetailsDTOList = new ArrayList<>(bookList.stream()
                                                        .map(book -> new BookDetailsDTO(
                                                                book.getId(),
                                                                book.getTitle(),
                                                                book.getAuthor(),
                                                                book.getPublishedDate(),
                                                                book.getIsbn(),
                                                                book.getStatus()
                                                        )).toList());

        return new ResponseEntity<>(bookDetailsDTOList, HttpStatus.OK);
    }

}
