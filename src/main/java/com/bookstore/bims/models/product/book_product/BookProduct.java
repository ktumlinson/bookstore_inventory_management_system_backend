package com.bookstore.bims.models.product.book_product;

import com.bookstore.bims.models.book.Book;
import com.bookstore.bims.models.product.Product;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "book_product", schema = "product")
public class BookProduct extends Product {
    @NotNull
    @ManyToOne()
    @JoinColumn(name = "condition_id", nullable = false)
    private BookCondition bookCondition;

    @NotNull
    @OneToOne()
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    /*
        book review Many to Many with secondary table
     */
}
