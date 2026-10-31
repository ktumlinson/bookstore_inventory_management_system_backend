package com.bookstore.bims.dtos.product;

public class ProductTypeDTO {
    public record CreateRequest(
        String name,
        String sku_prefix
    ){}

    public record SearchRequest(
        String name
    ){}

    public record Response(
        Long id,
        String name,
        String sku_prefix
    ){}
}
