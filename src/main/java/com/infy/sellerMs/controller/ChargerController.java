package com.infy.sellerMs.controller;
import com.infy.sellerMs.dto.ChargerDTO;
import com.infy.sellerMs.service.Interface.ChargerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/chargers")
public class ChargerController {
    @Autowired private ChargerService chargerService;

    @PostMapping
    public ChargerDTO create(@RequestBody ChargerDTO dto) {
        return chargerService.createCharger(dto);
    }

    @GetMapping
    public List<ChargerDTO> getAll() {
        return chargerService.getAllChargers();
    }

    @GetMapping("/{id}")
    public ChargerDTO getById(@PathVariable Long id) {
        return chargerService.getChargerById(id);
    }
}