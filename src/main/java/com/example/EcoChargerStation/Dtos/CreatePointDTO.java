package com.example.EcoChargerStation.Dtos;

import com.example.EcoChargerStation.Models.Station;

public record CreatePointDTO(Long id, Station stationId, String connectorType, double price, boolean availability) {
}
