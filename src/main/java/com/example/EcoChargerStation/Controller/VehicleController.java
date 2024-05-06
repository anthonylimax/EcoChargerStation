package com.example.EcoChargerStation.Controller;


import com.example.EcoChargerStation.Dtos.CreateVehicleDTO;
import com.example.EcoChargerStation.Models.Vehicle;
import com.example.EcoChargerStation.Repository.IVehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {

    @Autowired
    IVehicleRepository vehicleRepository;


    @PostMapping("/addvehicle")
   public ResponseEntity<CreateVehicleDTO> AddVeiculo(@RequestBody CreateVehicleDTO vehicle){
        try{
            CreateVehicleDTO vehicle1 = vehicleRepository.AddVehicle(vehicle);
            return ResponseEntity.ok().body(vehicle1);
        }
        catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.status(500).body(null);
        }
   }

}
