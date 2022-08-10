package com.parkinglot.model;

import com.parkinglot.enums.ParkingSpotType;

public abstract class ParkingSpot {

	private String id;
	private ParkingSpotType spotType;
	private String vehicleId;
	private Boolean isFree;

	public ParkingSpot(String id, ParkingSpotType type) {
		this.id = id;
		this.spotType = type;
	}

	public void assignVehicle(String vehicleId) {
		this.vehicleId = vehicleId;
		isFree = false;
	}

	public void freeSpot() {
		this.isFree = true;
		this.vehicleId = null;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public ParkingSpotType getSpotType() {
		return spotType;
	}

	public void setSpotType(ParkingSpotType spotType) {
		this.spotType = spotType;
	}

	public String getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(String vehicleId) {
		this.vehicleId = vehicleId;
	}

	public Boolean getIsFree() {
		return isFree;
	}

	public void setIsFree(Boolean isFree) {
		this.isFree = isFree;
	}
	
	

}
