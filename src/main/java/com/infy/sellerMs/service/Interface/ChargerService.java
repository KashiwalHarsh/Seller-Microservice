package com.infy.sellerMs.service.Interface;

import com.infy.sellerMs.dto.ChargerDTO;

import java.util.List;

public interface ChargerService {
    ChargerDTO createCharger(ChargerDTO chargerDTO);
    List<ChargerDTO> getAllChargers();
    ChargerDTO getChargerById(Long id);
}