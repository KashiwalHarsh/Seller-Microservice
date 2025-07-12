package com.infy.sellerMs.controller;
import com.infy.sellerMs.dto.ReviewDTO;
import com.infy.sellerMs.service.Interface.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @PostMapping
    public ReviewDTO create(@RequestBody ReviewDTO dto) {
        return reviewService.createReview(dto);
    }

    @GetMapping
    public List<ReviewDTO> getByTarget(
        @RequestParam(required = false) Long batteryId,
        @RequestParam(required = false) Long chargerId,
        @RequestParam(required = false) Long stationId) {
        return reviewService.getReviewsByTarget(batteryId, chargerId, stationId);
    }
}