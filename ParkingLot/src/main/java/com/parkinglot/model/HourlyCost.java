package com.parkinglot.model;

import java.util.HashMap;
import java.util.Map;

import com.parkinglot.enums.ParkingSpotType;

public class HourlyCost {

	 private Map<ParkingSpotType, Double> hourlyCosts = new HashMap<ParkingSpotType, Double>();

	    public HourlyCost() {
	        hourlyCosts.put(ParkingSpotType.COMPACT, 20.0);
	        hourlyCosts.put(ParkingSpotType.LARGE, 30.0);
	        hourlyCosts.put(ParkingSpotType.MOTORBIKE, 10.0);
	        hourlyCosts.put(ParkingSpotType.HANDICAPPED, 25.0);
	    }

	    public double getCost(ParkingSpotType parkingSpotType) {
	        return hourlyCosts.get(parkingSpotType);
	    }
}
