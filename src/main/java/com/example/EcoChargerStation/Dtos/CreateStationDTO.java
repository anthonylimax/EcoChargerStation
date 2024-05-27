package com.example.EcoChargerStation.Dtos;

import com.example.EcoChargerStation.Models.Address;
import com.example.EcoChargerStation.Models.Supplier;

public record CreateStationDTO(Supplier supplierId, String description, String name, Address addressId) {
}
