package com.test.librarySystem.dtos.response;

import com.test.librarySystem.utils.Status;

import java.time.LocalDate;

public record BookDetailsDTO(
        Long id,
        String title,
        String author,
        LocalDate publishedDate,
        String isbn,
        Status status
) {
}
