package com.example.EcoChargerStation.Models;


import jakarta.persistence.*;

@Entity
@Table
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private double longitude;
	private double latitude;

}
