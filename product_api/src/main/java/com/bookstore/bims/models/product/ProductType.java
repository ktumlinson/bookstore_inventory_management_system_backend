package com.bookstore.bims.models.product;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "product_type", schema = "product")
public class ProductType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // This will be something like Book mark
    @NotBlank
    private String name;

    // This is the sku prefix, EX Bookmark would be BM, apparel will be AP
    @NotBlank
    @Size(min = 2, max = 2)
    private String sku_prefix;
}
