package com.example.EcoChargerStation.Models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;



@Table
@Entity
public class Client extends User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String cpf;

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


}
