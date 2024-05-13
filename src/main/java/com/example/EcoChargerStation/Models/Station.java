package com.example.EcoChargerStation.Models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table
public class Station {
	@Id
	private Long id;
	@ManyToOne
	@JoinColumn(referencedColumnName = "id", name = "supplier_id")
	private Supplier supplier;
	private String description;
	private String name;
	@OneToOne
	@JoinColumn(name = "address_id", referencedColumnName = "id")
	private Address addressId;

	public void setStationId(Long stationId) {
		this.id = stationId;
	}

	public void setAddressId(Address addressId) {
		this.addressId = addressId;
	}


	public Long getStationId() {
		return id;
	}

	public Address getAddressId() {
		return addressId;
	}
}
