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
@Table(name = "batteries")
public class Battery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;
    private Double capacity;
    private String connectorType;
    private String companyName;
    private Integer ageInMonths;
    private Integer quantityAvailable;
    private Double pricePerBattery;

    @Embedded
    private Location location;

    private Double rating;

    @ManyToOne
    @JoinColumn(name = "seller_id")
    private Seller seller;

    @OneToMany(mappedBy = "battery", cascade = CascadeType.ALL)
    private List<Review> reviews;
}

