package com.bookstore.bims.models.address;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "state", schema = "address")
public class State {
    @Id
    @Column(name = "state_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long stateId;
    @Column(name = "state_name", nullable = false)
    private String stateName;
    @Column(name = "state_code", nullable = false)
    private String stateCode;
    @ManyToOne
    @JoinColumn(name = "country_id", nullable = false)
    private Country country;
}
