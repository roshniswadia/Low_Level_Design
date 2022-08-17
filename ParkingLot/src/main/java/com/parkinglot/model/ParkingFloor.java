package com.parkinglot.model;

import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedDeque;

import javax.management.RuntimeErrorException;

import com.parkinglot.enums.ParkingSpotType;
import com.parkinglot.enums.VehicleType;

public class ParkingFloor {
	

	private String floorId;
	public String getFloorId() {
		return floorId;
	}

	public void setFloorId(String floorId) {
		this.floorId = floorId;
	}

	public Map<ParkingSpotType, Deque<ParkingSpot>> getParkingSpots() {
		return parkingSpots;
	}

	public void setParkingSpots(Map<ParkingSpotType, Deque<ParkingSpot>> parkingSpots) {
		this.parkingSpots = parkingSpots;
	}

	public Map<ParkingSpotType, HashSet<ParkingSpot>> getUsedParkingSpots() {
		return usedParkingSpots;
	}

	public void setUsedParkingSpots(Map<ParkingSpotType, HashSet<ParkingSpot>> usedParkingSpots) {
		this.usedParkingSpots = usedParkingSpots;
	}

	public int getTotalLargeSpots() {
		return totalLargeSpots;
	}

	public void setTotalLargeSpots(int totalLargeSpots) {
		this.totalLargeSpots = totalLargeSpots;
	}

	public int getTotalCompactSpots() {
		return totalCompactSpots;
	}

	public void setTotalCompactSpots(int totalCompactSpots) {
		this.totalCompactSpots = totalCompactSpots;
	}

	public int getTotalMotorbikeSpots() {
		return totalMotorbikeSpots;
	}

	public void setTotalMotorbikeSpots(int totalMotorbikeSpots) {
		this.totalMotorbikeSpots = totalMotorbikeSpots;
	}

	public int getTotalHandicappedSpots() {
		return totalHandicappedSpots;
	}

	public void setTotalHandicappedSpots(int totalHandicappedSpots) {
		this.totalHandicappedSpots = totalHandicappedSpots;
	}

	Map<ParkingSpotType, Deque<ParkingSpot>> parkingSpots = new HashMap<ParkingSpotType, Deque<ParkingSpot>>();
	Map<ParkingSpotType, HashSet<ParkingSpot>> usedParkingSpots = new HashMap<ParkingSpotType, HashSet<ParkingSpot>>();
	int totalLargeSpots;
	int totalCompactSpots;
	int totalMotorbikeSpots;
	int totalHandicappedSpots;

	public ParkingFloor(String floorId, int totalLargeSpots, int totalCompactSpots, int totalMotorbikeSpots,
			int totalHandicappedSpots) {
		this.floorId = floorId;
		this.totalCompactSpots = totalCompactSpots;
		this.totalHandicappedSpots = totalHandicappedSpots;
		this.totalLargeSpots = totalLargeSpots;
		this.totalMotorbikeSpots = totalMotorbikeSpots;
		parkingSpots.put(ParkingSpotType.LARGE, new ConcurrentLinkedDeque<ParkingSpot>());
		parkingSpots.put(ParkingSpotType.COMPACT, new ConcurrentLinkedDeque<ParkingSpot>());
		parkingSpots.put(ParkingSpotType.MOTORBIKE, new ConcurrentLinkedDeque<ParkingSpot>());
		parkingSpots.put(ParkingSpotType.HANDICAPPED, new ConcurrentLinkedDeque<ParkingSpot>());
		usedParkingSpots.put(ParkingSpotType.LARGE, new HashSet<ParkingSpot>());
		usedParkingSpots.put(ParkingSpotType.COMPACT, new HashSet<ParkingSpot>());
		usedParkingSpots.put(ParkingSpotType.MOTORBIKE, new HashSet<ParkingSpot>());
		usedParkingSpots.put(ParkingSpotType.HANDICAPPED, new HashSet<ParkingSpot>());
	}

	public ParkingSpot getSpot(VehicleType vehicleType) {
		ParkingSpotType parkingSpotType = getSpotTypeforVehicle(vehicleType);

		// no spot available on this floor
		if (usedParkingSpots.get(parkingSpotType).size() >= getTotalAvailableSpots(vehicleType)) {
			return null;
		}

		ParkingSpot parkingSpot = parkingSpots.get(parkingSpotType).poll();
		usedParkingSpots.get(parkingSpotType).add(parkingSpot);
		return parkingSpot;
	}

	public ParkingSpotType getSpotTypeforVehicle(VehicleType type) {
		if (type == VehicleType.BUS || type == VehicleType.TRUCK)
			return ParkingSpotType.LARGE;
		else if (type == VehicleType.MOTORBIKE)
			return ParkingSpotType.MOTORBIKE;
		else if (type == VehicleType.CAR)
			return ParkingSpotType.COMPACT;
		else if (type == VehicleType.HANDICAPPED)
			return ParkingSpotType.HANDICAPPED;
		else
			throw new RuntimeException("Wrong Vehicle type");
	}

	public int getTotalAvailableSpots(VehicleType type) {
		if (type == VehicleType.BUS || type == VehicleType.TRUCK)
			return totalLargeSpots;
		else if (type == VehicleType.MOTORBIKE)
			return totalMotorbikeSpots;
		else if (type == VehicleType.CAR)
			return totalCompactSpots;
		else if (type == VehicleType.HANDICAPPED)
			return totalHandicappedSpots;
		else
			return 0;
	}

	public boolean emptySpot(ParkingSpot parkingSpot) {
		boolean parkingSpotRemoved = usedParkingSpots.get(parkingSpot.getSpotType()).remove(parkingSpot);
		if (parkingSpotRemoved) {
			parkingSpot.freeSpot();
			parkingSpots.get(parkingSpot.getSpotType()).addFirst(parkingSpot);
			return parkingSpotRemoved;
		}else {
			System.out.println("Spot Was empty or does not exist");
			return false;
		}
	}

}
