package com.parkinglot.model;

import java.time.LocalDateTime;
import java.util.Optional;

import com.parkinglot.exceptions.InvalidParkingFloorException;
import com.parkinglot.service.ParkingLotService;

public class Admin extends Account {
	
	public Admin() {
		super();
	}

	public Admin(String id, String username, String password, LocalDateTime lastAccessTime, String phoneNumber) {
		super(id, username, password, lastAccessTime, phoneNumber);
	}
	 public void addParkingFloor(ParkingFloor parkingFloor) {
	        Optional<ParkingFloor> floor =
	                ParkingLotService.INSTANCE.getParkingFloorsList().stream()
	                        .filter(pF -> pF.getFloorId().equalsIgnoreCase(parkingFloor.getFloorId()))
	                        .findFirst();
	        if (floor.isPresent())
	            return;
	        ParkingLotService.INSTANCE.getParkingFloorsList().add(parkingFloor);
	    }

	    public void addParkingSpot(String parkingFloorId, ParkingSpot parkingSpot)
	            throws InvalidParkingFloorException {
	        Optional<ParkingFloor> floor =
	                ParkingLotService.INSTANCE.getParkingFloorsList().stream()
	                        .filter(pF -> pF.getFloorId().equalsIgnoreCase(parkingFloorId))
	                        .findFirst();
	        if (!floor.isPresent())
	            throw new InvalidParkingFloorException("Invalid floor");

	        Optional<ParkingSpot> spot =
	                floor.get().getParkingSpots().get(parkingSpot.getSpotType())
	                        .stream()
	                        .filter(pS -> pS.getId().equalsIgnoreCase(parkingSpot.getId()))
	                        .findFirst();
	        if (spot.isPresent())
	            return;

	        floor.get().getParkingSpots().get(parkingSpot.getSpotType())
	                .addLast(parkingSpot);
	    }

	    public void addEntrancePanel(EntrancePanel entrancePanel) {
	        Optional<EntrancePanel> panel =
	                ParkingLotService.INSTANCE.getEntrancePanels().stream()
	                        .filter(eP -> eP.getId().equalsIgnoreCase(entrancePanel.getId())).findFirst();
	        if (panel.isPresent())
	            return;
	        ParkingLotService.INSTANCE.getEntrancePanels().add(entrancePanel);
	    }

	    public void addExitPanel(ExitPanel exitPanel) {
	        Optional<ExitPanel> panel =
	                ParkingLotService.INSTANCE.getExitPanels().stream()
	                        .filter(eP -> eP.getId().equalsIgnoreCase(exitPanel.getId())).findFirst();
	        if (panel.isPresent())
	            return;
	        ParkingLotService.INSTANCE.getExitPanels().add(exitPanel);
	    }
}
