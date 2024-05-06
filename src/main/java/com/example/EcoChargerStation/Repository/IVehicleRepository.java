package com.example.EcoChargerStation.Repository;

import com.example.EcoChargerStation.Dtos.CreateVehicleDTO;
import com.example.EcoChargerStation.Models.Vehicle;
import org.springframework.stereotype.Repository;


public interface IVehicleRepository {
    public CreateVehicleDTO AddVehicle(CreateVehicleDTO vehicle);
}
