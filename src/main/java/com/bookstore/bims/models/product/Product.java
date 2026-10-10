/*
    Abstract class for all product types
 */

package com.bookstore.bims.models.product;


import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

@Entity
@Table(name = "product", schema = "product")
public abstract class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    // in books sku = ISBN
    // in books with no ISBN use BK+Database ID
    // in things like bookmarks use something like BM-DatabaseId"
    // where the first set is the sku_prefix and the second is the items id in the DB
    private String sku;

    @NotBlank
    private String productName;

    @NotNull
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    @NotNull
    @Min(0)
    private Integer quantity;

    @ManyToOne()
    @JoinColumn(name = "product_type_id", nullable = false)
    private ProductType productType;
}
