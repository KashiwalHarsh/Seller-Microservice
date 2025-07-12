package com.infy.sellerMs.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="charging_stations")
public class ChargingStation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String stationName;

    @Embedded
    private Location location;

    private String address;
    private Double stationRating;
    private String facilities; // Optional, can be List<String> with @ElementCollection

    @ManyToOne
    @JoinColumn(name = "seller_id")
    private Seller seller;

    @OneToMany(mappedBy = "chargingStation", cascade = CascadeType.ALL)
    private List<Charger> chargers;

    @OneToMany(mappedBy = "chargingStation", cascade = CascadeType.ALL)
    private List<Review> reviews;
}

