package com.infy.sellerMs.service.Interface;

import com.infy.sellerMs.dto.ChargingStationDTO;

import java.util.List;

public interface ChargingStationService {
    ChargingStationDTO createStation(ChargingStationDTO dto);
    List<ChargingStationDTO> getAllStations();
    ChargingStationDTO getStationById(Long id);
}