package com.infy.sellerMs.service.Impl;
import com.infy.sellerMs.dto.BatteryDTO;
import com.infy.sellerMs.entity.Battery;
import com.infy.sellerMs.repository.BatteryRepository;
import com.infy.sellerMs.repository.SellerRepository;
import com.infy.sellerMs.service.Interface.BatteryService;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BatteryServiceImpl implements BatteryService {

    @Autowired
    private BatteryRepository batteryRepository;
    @Autowired
    private SellerRepository sellerRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public BatteryDTO createBattery(BatteryDTO batteryDTO) {
        Battery battery = modelMapper.map(batteryDTO, Battery.class);
        return modelMapper.map(batteryRepository.save(battery), BatteryDTO.class);
    }

    @Override
    public List<BatteryDTO> getAllBatteries() {
        return batteryRepository.findAll().stream()
            .map(battery -> modelMapper.map(battery, BatteryDTO.class))
            .collect(Collectors.toList());
    }

    @Override
    public BatteryDTO getBatteryById(Long id) {
        Battery battery = batteryRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Battery not found with ID: " + id));
        return modelMapper.map(battery, BatteryDTO.class);
    }
}