package bookstore.bims.book_api.dto;

import bookstore.bims.book_api.model.Book;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BookDTO {
    public record SearchRequest(
            String bookTitle,
            String authorName,
            String genreName

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

    public static BookDTO.Summary mapToSummary(Book book)
    {
        return new BookDTO.Summary(
                book.getIsbn10(),
                book.getIsbn13(),
                book.getBookTitle()
        );
    }

    public static Set<BookDTO.Summary> mapToSummary(Set<Book> books)
    {
        Set<BookDTO.Summary> dtos = new HashSet<>();
        for(Book b : books)
        {
            dtos.add( new Summary(
                    b.getIsbn10(),
                    b.getIsbn13(),
                    b.getBookTitle()
                    )
            );
        }
        return dtos;
    }
}
