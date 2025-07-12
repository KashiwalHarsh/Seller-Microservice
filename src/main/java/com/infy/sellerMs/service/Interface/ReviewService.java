package com.infy.sellerMs.service.Interface;

import com.infy.sellerMs.dto.ReviewDTO;

import java.util.List;

public interface ReviewService {
    ReviewDTO createReview(ReviewDTO reviewDTO);
    List<ReviewDTO> getReviewsByTarget(Long batteryId, Long chargerId, Long stationId);
}