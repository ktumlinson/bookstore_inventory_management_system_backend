package com.bookstore.bims.models.book;

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
@Table(name = "cover_type", schema = "book")
public class CoverType {
    @Id
    @Column(name = "cover_type_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank
    @Size(min = 2, max = 20)
    @Column(name = "cover_type_name", nullable = false)
    private String coverTypeName;
}
