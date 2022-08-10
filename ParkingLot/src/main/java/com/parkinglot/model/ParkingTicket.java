package com.parkinglot.model;

import java.time.LocalDateTime;

import com.parkinglot.enums.ParkingSpotType;

public class ParkingTicket {
	public String id;
	public LocalDateTime issueTime;
	public String vehicleLicense;
	public String parkingSpotId;
	public ParkingSpotType spotType;
	public String ticketNumber;
	public Double charge;
	public Double getCharge() {
		return charge;
	}
	public void setCharge(Double charge) {
		this.charge = charge;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public LocalDateTime getIssueTime() {
		return issueTime;
	}
	public void setIssueTime(LocalDateTime issueTime) {
		this.issueTime = issueTime;
	}
	public String getVehicleLicense() {
		return vehicleLicense;
	}
	public void setVehicleLicense(String vehicleLicense) {
		this.vehicleLicense = vehicleLicense;
	}
	public String getParkingSpotId() {
		return parkingSpotId;
	}
	public void setParkingSpotId(String parkingSpotId) {
		this.parkingSpotId = parkingSpotId;
	}
	public String getTicketNumber() {
		return ticketNumber;
	}
	public void setTicketNumber(String ticketNumber) {
		this.ticketNumber = ticketNumber;
	}
	public ParkingSpotType getSpotType() {
		return spotType;
	}
	public void setSpotType(ParkingSpotType spotType) {
		this.spotType = spotType;
	}
	
}
