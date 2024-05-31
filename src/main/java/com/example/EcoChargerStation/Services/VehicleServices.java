package com.example.EcoChargerStation.Services;


import com.example.EcoChargerStation.Dtos.CreateVehicleDTO;
import com.example.EcoChargerStation.Exceptions.VehicleExceptions.VehicleNotFoundException;
import com.example.EcoChargerStation.Repository.interfaces.IVehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehicleServices {

    @Autowired
    IVehicleRepository vehicleRepository;


    public CreateVehicleDTO AddVehicle(CreateVehicleDTO vehicle) {
        return vehicleRepository.AddVehicle(vehicle);
    }
    public void DeleteVehicleByID(long id) throws VehicleNotFoundException{
        if(vehicleRepository.ExistAVehicle(id)) vehicleRepository.DeleteVehicle(id);
        else throw new VehicleNotFoundException();
    }

}
