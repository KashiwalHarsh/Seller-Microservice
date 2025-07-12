package com.infy.sellerMs.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BatteryDTO {
    private Long id;
    private String type;
    private Double capacity;
    private String connectorType;
    private String companyName;
    private Integer ageInMonths;
    private Integer quantityAvailable;
    private Double pricePerBattery;
    private LocationDTO location;
    private Double rating;
}

