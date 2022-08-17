package com.parkinglot.model;

import com.parkinglot.enums.VehicleType;

public abstract class Vehicle {

	private String licenseNumber;
	private VehicleType vehicleType;
	private ParkingTicket parkingTicket;

	public Vehicle(String licenseNumber, VehicleType vehicleType, ParkingTicket parkingTicket) {
		super();
		this.licenseNumber = licenseNumber;
		this.vehicleType = vehicleType;
		this.parkingTicket = parkingTicket;
	}

	public String getLicenseNumber() {
		return licenseNumber;
	}

	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}

	public VehicleType getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(VehicleType vehicleType) {
		this.vehicleType = vehicleType;
	}

	public ParkingTicket getParkingTicket() {
		return parkingTicket;
	}

	public void setParkingTicket(ParkingTicket parkingTicket) {
		this.parkingTicket = parkingTicket;
	}
	

}
