package com.example.EcoChargerStation.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
public class Station {
	@Id
	private Long id;
	@ManyToOne
	@JoinColumn(referencedColumnName = "id", name = "supplier_id")
	private Supplier supplierId;
	private String description;
	private String name;
	@OneToOne
	@JoinColumn(name = "address_id", referencedColumnName = "id")
	private Address addressId;
}
