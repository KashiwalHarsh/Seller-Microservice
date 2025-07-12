package com.infy.sellerMs.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="chargers")
public class Charger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String connectorTypes; // Can also be List<String> with @ElementCollection
    private Double capacityInKw;
    private Double pricePerKw;
    private String chargingSpeed;
    private String supportedVehicles;
    private String brandName;
    private LocalTime openTime;
    private LocalTime closeTime;
    private Double rating;

    @ManyToOne
    @JoinColumn(name = "station_id")
    private ChargingStation chargingStation;

    @OneToMany(mappedBy = "charger", cascade = CascadeType.ALL)
    private List<Review> reviews;
}

