package com.example.EcoChargerStation.Services;


import com.example.EcoChargerStation.Dtos.CreateVehicleDTO;
import com.example.EcoChargerStation.Models.Vehicle;
import com.example.EcoChargerStation.Repository.IVehicleRepository;
import com.example.EcoChargerStation.Repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehicleServices {

    @Autowired
    IVehicleRepository vehicleRepository;


    public CreateVehicleDTO AddVehicle(CreateVehicleDTO vehicle) {
        return vehicleRepository.AddVehicle(vehicle);
    }

}
