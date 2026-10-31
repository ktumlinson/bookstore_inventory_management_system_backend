package com.bookstore.bims.dtos.book;

import java.util.Set;

public class SeriesDTO {
    public record SearchRequest(
            String seriesName
    ){}

    public record CreateRequest(
            String seriesName
    ){}

    public record Response(
            Long id,
            String seriesName,
            Set<BookDTO.Summary> books
    ){}

    public record Summary(
            Long id,
            String seriesName
    ){}
}
