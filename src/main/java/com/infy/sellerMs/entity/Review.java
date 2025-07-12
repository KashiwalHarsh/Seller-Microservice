package com.infy.sellerMs.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="reviews")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private Integer rating;
    private String description;

    private LocalDateTime createdAt;

    @ManyToOne
    private Battery battery;

    @ManyToOne
    private Charger charger;

    @ManyToOne
    private ChargingStation chargingStation;
}
