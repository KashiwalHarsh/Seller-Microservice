package com.infy.sellerMs.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReviewDTO {
    private Long id;
    private Long userId;
    private Integer rating;
    private String description;
    private LocalDateTime createdAt;

    // IDs to identify which entity the review is about
    private Long batteryId;
    private Long chargerId;
    private Long chargingStationId;
}
