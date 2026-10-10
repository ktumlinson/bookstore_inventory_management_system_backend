package com.bookstore.bims.models.product.book_product;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "book_product_review", schema = "book_product")
public class BookProductReview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /*
        needs book product here
     */
    /*
        needs customer id
     */
    @DecimalMin("0.0")
    @DecimalMax("5.0")
    private double rating;

    @NotBlank
    @Column(name = "review_text")
    @Size(min = 10, max = 500)
    private String reviewText;
}
