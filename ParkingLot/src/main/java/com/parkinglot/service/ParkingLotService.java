package com.parkinglot.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.parkinglot.enums.VehicleType;
import com.parkinglot.model.EntrancePanel;
import com.parkinglot.model.ExitPanel;
import com.parkinglot.model.ParkingFloor;
import com.parkinglot.model.ParkingSpot;

public class ParkingLotService {

	private String parkingLotId;
	private List<ParkingFloor> parkingFloorsList;
	private List<EntrancePanel> entrancePanels;
	private List<ExitPanel> exitPanels;
	public static ParkingLotService INSTANCE = new ParkingLotService();

	private ParkingLotService() {
		this.parkingLotId = UUID.randomUUID().toString();
		parkingFloorsList = new ArrayList<>();
		entrancePanels = new ArrayList<>();
		exitPanels = new ArrayList<>();
	}

	public ParkingSpot getParkingSpot(VehicleType vehicleType) {
		for (ParkingFloor parkingFloor : parkingFloorsList) {
			ParkingSpot parkingSpot = parkingFloor.getSpot(vehicleType);
			if (parkingSpot != null) {
				return parkingSpot;
			}
		}
		return null;
	}

	public ParkingSpot emptySpot(ParkingSpot parkingSpot) {
		for (ParkingFloor parkingFloor : parkingFloorsList) {
			Boolean spotRemoved = parkingFloor.emptySpot(parkingSpot);
			if (spotRemoved)
				return parkingSpot;
		}
		return null;
	}

	public String getParkingLotId() {
		return parkingLotId;
	}

	public void setParkingLotId(String parkingLotId) {
		this.parkingLotId = parkingLotId;
	}

	public List<ParkingFloor> getParkingFloorsList() {
		return parkingFloorsList;
	}

	public void setParkingFloorsList(List<ParkingFloor> parkingFloorsList) {
		this.parkingFloorsList = parkingFloorsList;
	}

	public List<EntrancePanel> getEntrancePanels() {
		return entrancePanels;
	}

	public void setEntrancePanels(List<EntrancePanel> entrancePanels) {
		this.entrancePanels = entrancePanels;
	}

	public List<ExitPanel> getExitPanels() {
		return exitPanels;
	}

	public void setExitPanels(List<ExitPanel> exitPanels) {
		this.exitPanels = exitPanels;
	}

}
