package com.example.EcoChargerStation.Models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table
public class Supplier extends User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String cnpj;


	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

}
