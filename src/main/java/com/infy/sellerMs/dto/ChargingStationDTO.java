package com.infy.sellerMs.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChargingStationDTO {
    private Long id;
    private String stationName;
    private LocationDTO location;
    private String address;
    private Double stationRating;
    private String facilities; // Or List<String>
    private Long sellerId;
}

