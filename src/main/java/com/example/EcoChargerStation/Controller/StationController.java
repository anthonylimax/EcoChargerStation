package com.example.EcoChargerStation.Controller;
import com.example.EcoChargerStation.Dtos.CreateStationDTO;
import com.example.EcoChargerStation.Repository.IStationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/station")
public class StationController {

    @Autowired
    IStationRepository stationRepository;

    @PostMapping("/addstation")
    public ResponseEntity<CreateStationDTO> AddPoint(@RequestBody CreateStationDTO station){
        try{
            CreateStationDTO station1 = stationRepository.AddStation(station);
            return ResponseEntity.ok().body(station1);
        }
        catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.status(500).body(null);
        }
    }
}
