package com.example.EcoChargerStation.Controller;


import com.example.EcoChargerStation.Dtos.CreatePointDTO;
import com.example.EcoChargerStation.Repository.IPointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/point")
public class PointController {

    @Autowired
    IPointRepository pointRepository;

    @PostMapping("/addpoint")
    public ResponseEntity<CreatePointDTO> AddPoint(@RequestBody CreatePointDTO point){
        try{
            CreatePointDTO point1 = pointRepository.AddPoint(point);
            return ResponseEntity.ok().body(point1);
        }
        catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.status(500).body(null);
        }
    }
}
