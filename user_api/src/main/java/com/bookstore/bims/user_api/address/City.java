package com.bookstore.bims.models.address;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "city", schema = "address")
public class City {
    @Id
    @Column(name = "city_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long citId;
    @Column(name = "city_name", nullable = false)
    private String cityName;
    @ManyToOne
    @JoinColumn(name = "state_id", nullable = false)
    private State state;
}
