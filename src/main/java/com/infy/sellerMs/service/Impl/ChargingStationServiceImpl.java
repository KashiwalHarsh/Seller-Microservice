package com.infy.sellerMs.service.Impl;
import com.infy.sellerMs.dto.ChargingStationDTO;
import com.infy.sellerMs.entity.ChargingStation;
import com.infy.sellerMs.entity.Seller;
import com.infy.sellerMs.repository.ChargingStationRepository;
import com.infy.sellerMs.repository.SellerRepository;
import com.infy.sellerMs.service.Interface.ChargingStationService;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ChargingStationServiceImpl implements ChargingStationService {

    @Autowired
    private ChargingStationRepository stationRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private SellerRepository sellerRepository;

    @Override
    public ChargingStationDTO createStation(ChargingStationDTO dto) {
        // Check if the seller exists
        Long sellerId = dto.getSellerId();
        Seller seller = sellerRepository.findById(sellerId)
                .orElseThrow(() -> new RuntimeException("Seller not found with ID: " + sellerId));

        // Map DTO to entity
        ChargingStation station = modelMapper.map(dto, ChargingStation.class);

        // Set the validated seller
        station.setSeller(seller);

        // Save and return mapped DTO
        ChargingStation savedStation = stationRepository.save(station);
        return modelMapper.map(savedStation, ChargingStationDTO.class);
    }


    @Override
    public List<ChargingStationDTO> getAllStations() {
        return stationRepository.findAll().stream()
            .map(station -> modelMapper.map(station, ChargingStationDTO.class))
            .collect(Collectors.toList());
    }

    @Override
    public ChargingStationDTO getStationById(Long id) {
        ChargingStation station = stationRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Station not found with ID: " + id));
        return modelMapper.map(station, ChargingStationDTO.class);
    }
}