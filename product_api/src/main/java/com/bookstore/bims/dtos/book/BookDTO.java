package com.bookstore.bims.dtos.book;

import java.util.Set;

public class BookDTO {
    public record SearchRequest(
            String bookTitle,
            String authorName,
            String gereName

    ){}

    public record CreateRequest(
        String isbn10,
        String isbn13,
        String bookTitle,
        String bookSummary,
        int pageCount,
        java.time.LocalDate publishDate,
        String imageLocation,
        Long seriesID,
        Long publisherId,
        Long coverTypeID,
        Set<Long> authorIds,
        Set<Long> genreIds
    ){}

    public record Response(
            Long id,
            String isbn10,
            String isbn13,
            String bookTitle,
            String bookSummary,
            int pageCount,
            java.time.LocalDate publishDate,
            String imageLocation,
            SeriesDTO.Summary series,
            PublisherDTO.Response publisher,
            CoverTypeDTO.Response coverType,
            Set<AuthorDTO.Summary> authors,
            Set<GenreDTO.Summary> genres
    ) {}

    public record Summary(
            String isbn10,
            String isbn13,
            String bookTitle
    ){}
}
