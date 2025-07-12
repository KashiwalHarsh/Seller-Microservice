package com.infy.sellerMs.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChargerDTO {
    private Long id;
    private String connectorTypes; // You can change this to List<String> if needed
    private Double capacityInKw;
    private Double pricePerKw;
    private String chargingSpeed;
    private String supportedVehicles;
    private String brandName;
    private LocalTime openTime;
    private LocalTime closeTime;
    private Double rating;
    private Long chargingStationId;
}

