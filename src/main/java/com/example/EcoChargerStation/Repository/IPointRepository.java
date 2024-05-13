package com.example.EcoChargerStation.Repository;

import com.example.EcoChargerStation.Dtos.CreatePointDTO;
import com.example.EcoChargerStation.Models.Point;

public interface IPointRepository {
    public CreatePointDTO AddPoint(CreatePointDTO point);
}
