package com.example.EcoChargerStation.Repository;

import com.example.EcoChargerStation.Dtos.CreatePointDTO;

public interface IPointRepository {
    public CreatePointDTO AddPoint(CreatePointDTO point);
}
