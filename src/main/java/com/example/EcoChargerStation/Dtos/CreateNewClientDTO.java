package com.example.EcoChargerStation.Dtos;

import jakarta.validation.constraints.NotBlank;

public record CreateNewClientDTO(@NotBlank String name, String password, String email, String phone, String userName, String cpf) {
}
