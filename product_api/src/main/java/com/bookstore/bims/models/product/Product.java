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
import java.util.Set;

@Entity
@Table(name = "product", schema = "product")
public abstract class Product {
    @Id
    @Column(name = "product_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 2, max = 255)
    private String productName;

    @NotNull
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    @Min(0)
    @NotNull
    private Integer quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_type_id", nullable = false)
    private ProductType productType;

    // in books sku = ISBN
    // in books with no ISBN use BK+Database ID
    // in things like bookmarks use something like BM-DatabaseId"
    // where the first set is the sku_prefix and the second is the items id in the DB
    @NotBlank
    private String sku = productType.getSku_prefix()+id;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    @Column(nullable = true)
    private Set<Review> reviews;
}
