package com.example.EcoChargerStation.Dtos;

import jakarta.validation.constraints.NotBlank;

    @NotBlank
    public record CreateVehicleDTO(Long ownerId, String brand, String model, String year) {
}
