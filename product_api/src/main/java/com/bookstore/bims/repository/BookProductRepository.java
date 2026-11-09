package com.bookstore.bims.repository;

import com.bookstore.bims.models.product.book_product.BookProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookProductRepository extends JpaRepository<BookProduct, Long> {
    Optional<BookProduct> findByBook_Isbn10(String isbn10);
    Optional<BookProduct> findByBook_Isbn13(String isbn13);
    List<BookProduct> findByBook_Authors_FirstName(String firstName, String lastName);
}
