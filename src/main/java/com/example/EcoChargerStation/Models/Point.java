package com.example.EcoChargerStation.Models;

import jakarta.persistence.*;

@Entity
@Table
public class Point {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@ManyToOne
	@JoinColumn(referencedColumnName = "id", name="station_id")
	private Station stationId;
	private String connectorType;
	private double price;
	private boolean availability;


	public Long getPointId() {
		return id;
	}

	public void setPointId(Long pointId) {
		this.id = pointId;
	}

	public Station getStationId() {
		return stationId;
	}

	public void setStationId(Station stationId) {
		this.stationId = stationId;
	}

	public String getConnectorType() {
		return connectorType;
	}

	public void setConnectorType(String connectorType) {
		this.connectorType = connectorType;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public boolean isAvailability() {
		return availability;
	}

	public void setAvailability(boolean availability) {
		this.availability = availability;
	}	
}
