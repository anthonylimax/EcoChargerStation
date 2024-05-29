package com.example.EcoChargerStation.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
public class Vehicle {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long vehicleId;
	private String brand;
	private String model;
	private String year;
	private Long ownerId;
}
