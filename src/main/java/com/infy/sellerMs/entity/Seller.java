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
@Table(name="sellers")
public class Seller {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String gstNumber;

    @Embedded
    private ContactInfo contactInfo;

    private Double rating;

    @OneToMany(mappedBy = "seller", cascade = CascadeType.ALL)
    private List<Battery> batteries;

    @OneToMany(mappedBy = "seller", cascade = CascadeType.ALL)
    private List<ChargingStation> stations;
}
