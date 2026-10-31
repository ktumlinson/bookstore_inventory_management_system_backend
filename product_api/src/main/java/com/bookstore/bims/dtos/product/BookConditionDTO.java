package com.bookstore.bims.dtos.product;

public class BookConditionDTO {
    public record CreateRequest(
        String conditionName
    ){}

    public record SearchRequest(
        String conditionName
    ){}

    public record Response(
        Long id,
        String conditionName
    ){}
}
