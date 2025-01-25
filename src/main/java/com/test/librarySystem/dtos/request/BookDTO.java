package com.test.librarySystem.dtos.request;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;


import java.time.LocalDate;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record BookDTO(
        @NotEmpty(message = "The title cannot be null or empty")
        @NotBlank(message = "The title cannot be blank spaces")
        String title,
        @NotEmpty(message = "The author cannot be null or empty")
        @NotBlank(message = "The author cannot be blank spaces")
        String author,
        @NotNull(message = "The title cannot be null or empty")
        LocalDate publishedDate,
        @NotEmpty(message = "The title cannot be null or empty")
        @NotBlank(message = "The title cannot be blank spaces")
        String isbn
) {
}
