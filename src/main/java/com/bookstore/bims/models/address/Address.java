package com.bookstore.bims.models.address;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "address", schema = "address")

public class Address {
    @Id
    @Column(name = "address_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long addressId;
    @Column(name = "street_address", nullable = false)
    private String streetAddress;
    @Column(name = "zip_code", nullable = false)
    private String zipCode;
    @ManyToOne
    @JoinColumn(name = "city_id", nullable = false)
    private City city;
}