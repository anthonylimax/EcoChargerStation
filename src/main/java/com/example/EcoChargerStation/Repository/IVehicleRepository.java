package com.example.EcoChargerStation.Repository;

import com.example.EcoChargerStation.Dtos.CreateVehicleDTO;


public interface IVehicleRepository {
    public CreateVehicleDTO AddVehicle(CreateVehicleDTO vehicle);
}
