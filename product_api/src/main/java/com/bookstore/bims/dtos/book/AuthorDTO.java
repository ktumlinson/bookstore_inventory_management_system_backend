package com.bookstore.bims.dtos.book;

import java.util.List;
import java.util.Set;

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
