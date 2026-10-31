package com.bookstore.bims.dtos.book;

public class CoverTypeDTO {
    public record SearchRequest(
            String coverTypeName
    ){}

    public record CreateRequest(
            String coverTypeName
    ){}

    public record Response(
            Long id,
            String coverTypeName
    ){}
}
