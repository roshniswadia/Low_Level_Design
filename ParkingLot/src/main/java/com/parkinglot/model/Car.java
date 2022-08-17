package com.parkinglot.model;

import com.parkinglot.enums.VehicleType;

public class Car extends Vehicle {
	
	public Car(String licenseNumber, VehicleType vehicleType, ParkingTicket parkingTicket) {
		super(licenseNumber, vehicleType, parkingTicket);
	}

}
