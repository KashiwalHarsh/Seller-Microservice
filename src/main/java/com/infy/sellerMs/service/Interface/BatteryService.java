package com.infy.sellerMs.service.Interface;
import com.infy.sellerMs.dto.BatteryDTO;
import java.util.List;

public interface BatteryService {
    BatteryDTO createBattery(BatteryDTO batteryDTO);
    List<BatteryDTO> getAllBatteries();
    BatteryDTO getBatteryById(Long id);
}