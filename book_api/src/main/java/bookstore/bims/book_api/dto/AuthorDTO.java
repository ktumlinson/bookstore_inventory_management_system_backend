package bookstore.bims.book_api.dto;

import bookstore.bims.book_api.model.Author;

import java.util.*;

public class AuthorDTO {
    public record SearchRequest(
            String firstName,
            String lastName
    ){}

    public record CreateRequest(
            String firstName,
            String lastName,
            List<Long> bookIds
    ){}

    public record Response(
            Long id,
            String firstName,
            String lastName,
            Set<BookDTO.Summary> books
    ){}

    public record Summary(
            Long id,
            String firstName,
            String lastName
    ){}


}
