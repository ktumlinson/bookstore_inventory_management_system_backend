package com.bookstore.bims.models.book;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "series", schema = "book")
public class Series {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 2, max = 255)
    @Column(name = "series_name", nullable = false)
    private String seriesName;

    @OneToMany(mappedBy = "series")
    private Set<Book> books;
}
