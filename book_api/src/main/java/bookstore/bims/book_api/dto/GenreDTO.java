package bookstore.bims.book_api.dto;

import java.util.Set;

public class GenreDTO {
    public record SearchRequest(
       String genreName
    ){}

    public record CreateRequest(
            String genreName
    ){}

    public record Response(
            Long id,
            String genreName,
            Set<BookDTO.Summary> books
    ){}

    public record Summary(
            Long id,
            String genreName
    ){}
}
