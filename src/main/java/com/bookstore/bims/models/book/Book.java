package com.bookstore.bims.models.book;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import org.springframework.http.HttpStatus;

import java.util.Date;
import java.util.concurrent.Flow;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "book", schema = "book", uniqueConstraints = {
        @UniqueConstraint(name = "unique_isbn_cover_condition",
                columnNames = {"isbn_10", "isbn_13", "book_title", "cover_type_id"
        })
})
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min=10, max=10)
    @Column(name = "isbn_10", nullable = true, unique = true)
    private String isbn10;

    @Size(min = 13, max = 13)
    @Column(name = "isbn_13", nullable = true, unique = true)
    private String isbn13;

    @Size(min = 2, max = 255)
    @Column(name = "book_title", nullable = false)
    private String bookTitle;

    @Size(min = 2, max = 500)
    @Column(name = "book_summary", nullable = true)
    private String bookSummary;

    @Column(name = "page_count", nullable = false)
    private int pageCount;

    @Temporal(TemporalType.DATE)
    @Column(name = "publish_date", nullable = false)
    private Date publishDate;

    @NotBlank
    @Column(name = "image_location", nullable = false)
    private String imageLocation;

    @ManyToOne()
    @JoinColumn(name = "publisher_id", nullable = false)
    private Publisher publisher;

    @ManyToOne()
    @JoinColumn(name = "series_id", nullable = true)
    private Series series;

    @ManyToOne()
    @JoinColumn(name = "cover_type_id", nullable = false)
    private CoverType coverType;

    /*
        Many to Many with Author book that makes a secondary table
     */
}
