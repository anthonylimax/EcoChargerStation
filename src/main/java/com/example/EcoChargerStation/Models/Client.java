package com.example.EcoChargerStation.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Table
@Entity
public class Client extends User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@NotBlank
	private String cpf;

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


}
