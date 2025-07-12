package com.infy.sellerMs.service.Impl;

import com.infy.sellerMs.dto.ChargerDTO;
import com.infy.sellerMs.entity.Charger;
import com.infy.sellerMs.entity.ChargingStation;
import com.infy.sellerMs.repository.ChargerRepository;
import com.infy.sellerMs.repository.ChargingStationRepository;
import com.infy.sellerMs.service.Interface.ChargerService;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ChargerServiceImpl implements ChargerService {

    @Autowired
    private ChargerRepository chargerRepository;
    @Autowired
    private ChargingStationRepository stationRepository;
    @Autowired
    private ModelMapper modelMapper;

//    @Override
//    public ChargerDTO createCharger(ChargerDTO chargerDTO) {
//        Charger charger = modelMapper.map(chargerDTO, Charger.class);
//        return modelMapper.map(chargerRepository.save(charger), ChargerDTO.class);
//    }

    @Override
    public ChargerDTO createCharger(ChargerDTO chargerDTO) {

        Charger charger = modelMapper.map(chargerDTO, Charger.class);

        Long stationId = chargerDTO.getChargingStationId();
        ChargingStation station = stationRepository.findById(stationId)
                .orElseThrow(() -> new RuntimeException("Charging station not found with ID: " + stationId));

        charger.setChargingStation(station);
        Charger saved = chargerRepository.save(charger);
        return modelMapper.map(saved, ChargerDTO.class);
    }


    @Override
    public List<ChargerDTO> getAllChargers() {
        return chargerRepository.findAll().stream()
            .map(charger -> modelMapper.map(charger, ChargerDTO.class))
            .collect(Collectors.toList());
    }

    @Override
    public ChargerDTO getChargerById(Long id) {
        Charger charger = chargerRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Charger not found with ID: " + id));
        return modelMapper.map(charger, ChargerDTO.class);
    }
}