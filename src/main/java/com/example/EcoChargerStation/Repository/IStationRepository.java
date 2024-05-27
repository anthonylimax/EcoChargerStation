package com.example.EcoChargerStation.Repository;
import com.example.EcoChargerStation.Dtos.CreateStationDTO;

public interface IStationRepository {
    public CreateStationDTO AddStation(CreateStationDTO station);
}
