package com.example.EcoChargerStation.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table
public class Station {
	@Id
	private String stationId;
	private Long addressId;

	public void setStationId(String stationId) {
		this.stationId = stationId;
	}

	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}


	public String getStationId() {
		return stationId;
	}

	public Long getAddressId() {
		return addressId;
	}
}
