package com.test.librarySystem.services.impl;

import com.test.librarySystem.dtos.request.BookDTO;
import com.test.librarySystem.dtos.request.UpdateBookDTO;
import com.test.librarySystem.dtos.response.BookDetailsDTO;
import com.test.librarySystem.dtos.response.SimpleMessageResponse;
import com.test.librarySystem.entities.Book;
import com.test.librarySystem.exceptions.NotFoundException;
import com.test.librarySystem.repositories.BookRepository;
import com.test.librarySystem.services.IBookService;
import com.test.librarySystem.utils.ConvertBook;
import com.test.librarySystem.utils.Status;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements IBookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public BookDetailsDTO create(BookDTO book) {

        Book bookToSave = ConvertBook.bookDTOToBook(book);

        Optional<Book> bookDB = bookRepository.findByIsbn(book.isbn());

        if (bookDB.isPresent()) {
            throw  new IllegalArgumentException("The book with ISBN " + book.isbn() + " is already exist");
        }

        bookRepository.save(bookToSave);

        return new  BookDetailsDTO(
                        bookToSave.getId(),
                        bookToSave.getTitle(),
                        bookToSave.getAuthor(),
                        bookToSave.getPublishedDate(),
                        bookToSave.getIsbn(),
                        bookToSave.getStatus());

    }

    @Override
    public BookDetailsDTO getBookById(Long id) {
        Book bookFound = bookRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Book with id " + id + " does not exist"));

        return new BookDetailsDTO(
                        bookFound.getId(),
                        bookFound.getTitle(),
                        bookFound.getAuthor(),
                        bookFound.getPublishedDate(),
                        bookFound.getIsbn(),
                        bookFound.getStatus());

    }

    @Override
    public BookDetailsDTO update(Long id, UpdateBookDTO updateBook) {
        Book bookFound = bookRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Book with id " + id + " does not exist"));

        bookFound.setTitle(updateBook.title());
        bookFound.setAuthor(updateBook.author());
        bookFound.setPublishedDate(updateBook.publishedDate());
        bookFound.setIsbn(updateBook.isbn());
        bookFound.setStatus(Status.stringToEnum(updateBook.status()));

        bookRepository.save(bookFound);

        return new BookDetailsDTO(
                        bookFound.getId(),
                        bookFound.getTitle(),
                        bookFound.getAuthor(),
                        bookFound.getPublishedDate(),
                        bookFound.getIsbn(),
                        bookFound.getStatus());

    }

    @Override
    public SimpleMessageResponse delete(Long id) {
        Book bookFound = bookRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Book with id " + id + " does not exist"));

        bookRepository.deleteById(bookFound.getId());

        return new SimpleMessageResponse("Book with id " + bookFound.getId() + " was successfully deleted");

    }

    @Override
    public List<BookDetailsDTO> getAllBooks() {
        List<Book> bookList = bookRepository.findAll();

        return bookList.stream()
                .map(book -> new BookDetailsDTO(
                    book.getId(),
                    book.getTitle(),
                    book.getAuthor(),
                    book.getPublishedDate(),
                    book.getIsbn(),
                    book.getStatus()
                )).toList();

    }

}
