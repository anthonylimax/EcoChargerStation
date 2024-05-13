package com.example.EcoChargerStation.Models;

import jakarta.persistence.*;

@Entity
@Table

public class Recharge {
	@Id
	private Long rechargeId;
	@ManyToOne
	@JoinColumn(name = "point_id", referencedColumnName = "id")
	private Point pointId;
	@ManyToOne
	@JoinColumn(name = "client_id", referencedColumnName = "id")
	private Client client;
	private String rechargeDate;
	private double rechargeValue;
	private boolean availability;
	


	public Long getRechargeId() {
		return rechargeId;
	}

	public void setRechargeId(Long rechargeId) {
		this.rechargeId = rechargeId;
	}

	public Point getPointId() {
		return pointId;
	}

	public void setPointId(Point pointId) {
		this.pointId = pointId;
	}

	public Client getUserId() {
		return client;
	}

	public void setUserId(Client userId) {
		this.client = userId;
	}

	public String getRechargeDate() {
		return rechargeDate;
	}

	public void setRechargeDate(String rechargeDate) {
		this.rechargeDate = rechargeDate;
	}

	public double getRechargeValue() {
		return rechargeValue;
	}

	public void setRechargeValue(double rechargeValue) {
		this.rechargeValue = rechargeValue;
	}

	public boolean isAvailability() {
		return availability;
	}

	public void setAvailability(boolean availability) {
		this.availability = availability;
	}
}
