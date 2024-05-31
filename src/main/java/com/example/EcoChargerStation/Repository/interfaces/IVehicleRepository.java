package com.example.EcoChargerStation.Repository.interfaces;

import com.example.EcoChargerStation.Dtos.CreateVehicleDTO;


public interface IVehicleRepository {
    public CreateVehicleDTO AddVehicle(CreateVehicleDTO vehicle);
    public void DeleteVehicle(long id);
    public boolean ExistAVehicle(long id);

}
