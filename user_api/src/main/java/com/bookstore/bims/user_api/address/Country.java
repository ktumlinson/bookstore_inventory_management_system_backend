package com.bookstore.bims.models.address;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "country", schema = "address")
public class Country {
    @Id
    @Column(name = "country_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long countryId;
    @Column(name = "country_name", nullable = false, unique = true)
    private String countryName;
    @Column(name = "country_code", nullable = false, unique = true)
    private String countryCode;
}
