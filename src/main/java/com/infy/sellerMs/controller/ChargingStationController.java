package com.infy.sellerMs.controller;
import com.infy.sellerMs.dto.ChargingStationDTO;
import com.infy.sellerMs.service.Interface.ChargingStationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stations")
public class ChargingStationController {
    @Autowired private ChargingStationService stationService;

    @PostMapping
    public ChargingStationDTO create(@RequestBody ChargingStationDTO dto) {
        return stationService.createStation(dto);
    }

    @GetMapping
    public List<ChargingStationDTO> getAll() {
        return stationService.getAllStations();
    }

    @GetMapping("/{id}")
    public ChargingStationDTO getById(@PathVariable Long id) {
        return stationService.getStationById(id);
    }
}