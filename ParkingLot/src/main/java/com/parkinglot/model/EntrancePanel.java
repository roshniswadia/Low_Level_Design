package com.parkinglot.model;

import java.time.LocalDateTime;
import java.util.UUID;

import com.parkinglot.enums.ParkingSpotType;

public class EntrancePanel {
	
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public EntrancePanel(String id) {
		this.id = id;
	}
	
	public ParkingTicket getParkingTicket(Vehicle vehicle, String parkingSpotId, ParkingSpotType spotType) {
		ParkingTicket parkingTicket = new ParkingTicket();
        parkingTicket.setIssueTime(LocalDateTime.now());
        parkingTicket.setParkingSpotId(parkingSpotId);
        parkingTicket.setVehicleLicense(vehicle.getLicenseNumber());
        parkingTicket.setSpotType(spotType);
        parkingTicket.setTicketNumber(UUID.randomUUID().toString());
        return parkingTicket;
	}

}
