package com.parkinglot.model;

import java.time.Duration;
import java.time.LocalDateTime;

import com.parkinglot.enums.ParkingSpotType;

public class ExitPanel {

	private String id;

	public ExitPanel(String id) {
		super();
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public ParkingTicket scanAndVacate(ParkingTicket parkingTicket) {
		parkingTicket.setCharge(calculateCost(parkingTicket, parkingTicket.getSpotType()));
		return parkingTicket;
	}

	private double calculateCost(ParkingTicket parkingTicket, ParkingSpotType parkingSpotType) {
		Duration duration = Duration.between(parkingTicket.getIssueTime(), LocalDateTime.now());
		long hours = duration.toHours();
		if (hours == 0)
			hours = 1;
		double amount = hours * new HourlyCost().getCost(parkingSpotType);
		return amount;
	}
}
