package com.test.librarySystem.entities;

import com.test.librarySystem.utils.Status;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String title;
    @Column
    private String author;
    @Column
    private LocalDate publishedDate;
    @Column(unique = true)
    private String isbn;
    @Enumerated(EnumType.STRING)
    private Status status;

    public Book(String title, String author, LocalDate publishedDate, String isbn) {
        this.title = title;
        this.author = author;
        this.publishedDate = publishedDate;
        this.isbn = isbn;
        status = Status.AVAILABLE;
    }
}
