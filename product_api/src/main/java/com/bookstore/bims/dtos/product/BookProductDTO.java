package com.bookstore.bims.dtos.product;

import java.math.BigDecimal;

public class BookProductDTO {
    public record CreateRequest(
        String productName,
        BigDecimal price,
        int quantity,
        ProductTypeDTO.Response productType,
        String sku,
        BookProductDTO.CreateRequest book
    ){}

    public record SearchRequest(
        String productName
    ){}

    public record Response(
        Long id,
        String productName,
        BigDecimal price,
        int quantity,
        ProductTypeDTO.Response productType,
        String sku,
        BookProductDTO.Response book
    ){}
}
