package com.infy.sellerMs.controller;

import com.infy.sellerMs.dto.BatteryDTO;
import com.infy.sellerMs.service.Interface.BatteryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/batteries")
public class BatteryController {
    @Autowired
    private BatteryService batteryService;

    @PostMapping
    public BatteryDTO create(@RequestBody BatteryDTO dto) {
        return batteryService.createBattery(dto);
    }

    @GetMapping
    public List<BatteryDTO> getAll() {
        return batteryService.getAllBatteries();
    }

    @GetMapping("/{id}")
    public BatteryDTO getById(@PathVariable Long id) {
        return batteryService.getBatteryById(id);
    }
}