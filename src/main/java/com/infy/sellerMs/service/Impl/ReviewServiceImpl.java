package com.infy.sellerMs.service.Impl;

import com.infy.sellerMs.dto.ReviewDTO;
import com.infy.sellerMs.entity.Battery;
import com.infy.sellerMs.entity.Charger;
import com.infy.sellerMs.entity.ChargingStation;
import com.infy.sellerMs.entity.Review;
import com.infy.sellerMs.repository.BatteryRepository;
import com.infy.sellerMs.repository.ChargerRepository;
import com.infy.sellerMs.repository.ChargingStationRepository;
import com.infy.sellerMs.repository.ReviewRepository;
import com.infy.sellerMs.service.Interface.ReviewService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private BatteryRepository batteryRepository;
    @Autowired
    private ChargingStationRepository chargingStationRepository;
    @Autowired
    private ChargerRepository chargerRepository;

    @Override
    public ReviewDTO createReview(ReviewDTO dto) {
        // Validate that the battery exists

        // Map DTO to entity
        Review review;

        if(dto.getBatteryId()!=null){
            Long batteryId = dto.getBatteryId();
            Battery battery = batteryRepository.findById(batteryId)
                    .orElseThrow(() -> new RuntimeException("Battery not found with ID: " + batteryId));

            review = modelMapper.map(dto, Review.class);
            // Set validated battery (so Hibernate manages the foreign key correctly)
            review.setBattery(battery);
            review.setCharger(null);
            review.setChargingStation(null);
        }
        else if(dto.getChargingStationId()!=null){
            Long chargingStationId = dto.getChargingStationId();
            ChargingStation chargingStation = chargingStationRepository.findById(chargingStationId)
                    .orElseThrow(() -> new RuntimeException("Charging Station not found with ID: " + chargingStationId));

            review = modelMapper.map(dto, Review.class);
            // Set validated charging station (so Hibernate manages the foreign key correctly)
            review.setChargingStation(chargingStation);
            review.setCharger(null);
            review.setBattery(null);
        }
        else if(dto.getChargerId()!=null){
            Long chargerId = dto.getChargerId();
            Charger charger = chargerRepository.findById(chargerId)
                    .orElseThrow(() -> new RuntimeException("Charger not found with ID: " + chargerId));

            review = modelMapper.map(dto, Review.class);
            // Set validated charger (so Hibernate manages the foreign key correctly)
            review.setCharger(charger);
            review.setChargingStation(null);
            review.setBattery(null);
        }else{
            throw new RuntimeException("ALL are null");
        }

        // Set timestamp
        review.setCreatedAt(LocalDateTime.now());

        // Save and return
        Review saved = reviewRepository.save(review);
        return modelMapper.map(saved, ReviewDTO.class);
    }

//    @Override
//    public ReviewDTO createReview(ReviewDTO dto) {
//        Review review = modelMapper.map(dto, Review.class);
//        review.setCreatedAt(LocalDateTime.now());
//        return modelMapper.map(reviewRepository.save(review), ReviewDTO.class);
//    }

    @Override
    public List<ReviewDTO> getReviewsByTarget(Long batteryId, Long chargerId, Long stationId) {
        return reviewRepository.findAll().stream()
            .filter(r -> (batteryId != null && r.getBattery() != null && r.getBattery().getId().equals(batteryId)) ||
                         (chargerId != null && r.getCharger() != null && r.getCharger().getId().equals(chargerId)) ||
                         (stationId != null && r.getChargingStation() != null && r.getChargingStation().getId().equals(stationId)))
            .map(r -> modelMapper.map(r, ReviewDTO.class))
            .collect(Collectors.toList());
    }
}