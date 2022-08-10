package com.parkinglot;

import com.parkinglot.enums.ParkingSpotType;
import com.parkinglot.enums.VehicleType;
import com.parkinglot.exceptions.InvalidParkingFloorException;
import com.parkinglot.model.Account;
import com.parkinglot.model.Admin;
import com.parkinglot.model.Car;
import com.parkinglot.model.CarParkingSpot;
import com.parkinglot.model.EntrancePanel;
import com.parkinglot.model.ExitPanel;
import com.parkinglot.model.MotorBikeParkingSpot;
import com.parkinglot.model.Motorbike;
import com.parkinglot.model.ParkingFloor;
import com.parkinglot.model.ParkingSpot;
import com.parkinglot.model.ParkingTicket;
import com.parkinglot.model.Vehicle;
import com.parkinglot.service.ParkingLotService;

public class ParkingLotSystem {
	public static void main(String[] args) throws InvalidParkingFloorException {
        ParkingLotService parkingLot = ParkingLotService.INSTANCE;
        
        Account adminAccount = new Admin();
        //Admin Case 1 - should be able to add parking floor case
        ((Admin) adminAccount).addParkingFloor(new ParkingFloor("1", 50,20,20,10));
        //Admin Case 2 - should be able to add parking floor case
        ((Admin) adminAccount).addParkingFloor(new ParkingFloor("2", 50, 20 ,20 ,10));

        //Admin Case 3 - should be able to add entrance panel
        EntrancePanel entrancePanel = new EntrancePanel("1");
        ((Admin) adminAccount).addEntrancePanel(entrancePanel);

        //Admin Case 4 - should be able to add exit panel
        ExitPanel exitPanel = new ExitPanel("1");
        ((Admin) adminAccount).addExitPanel(exitPanel);
        
        String floorId = parkingLot.getParkingFloorsList().get(0).getFloorId();
        
      ///Admin case 5 - should be able to add car parking spot
        ParkingSpot carSpot1 = new CarParkingSpot("c1", ParkingSpotType.COMPACT);
        ((Admin) adminAccount).addParkingSpot(floorId, carSpot1);
        ///Admin case 6 - should be able to add bike parking spot
        ParkingSpot bikeSport = new MotorBikeParkingSpot("b1", ParkingSpotType.MOTORBIKE);
        ((Admin) adminAccount).addParkingSpot(floorId, bikeSport);
        ///Admin case 7 - should be able to add car parking spot
        ParkingSpot carSpot2 = new CarParkingSpot("c2", ParkingSpotType.COMPACT);
        ((Admin) adminAccount).addParkingSpot(floorId, carSpot2);
        
        // Test case 5 - get parking spot
        Vehicle vehicle = new Car("KA05MR2311", VehicleType.CAR, null);
        ParkingSpot availableSpot = ParkingLotService.INSTANCE.getParkingSpot(vehicle.getVehicleType());
        System.out.println(availableSpot.getSpotType());
        System.out.println(availableSpot.getId());
        
        // Test case 6 - should not be able to get spot
        Vehicle motorbike = new Motorbike("KA01MR7804", VehicleType.MOTORBIKE, null);
        ParkingSpot vanSpot = ParkingLotService.INSTANCE.getParkingSpot(motorbike.getVehicleType());
        System.out.println(null == vanSpot);
        
        ParkingTicket parkingTicket1 = entrancePanel.getParkingTicket(vehicle, availableSpot.getId(), availableSpot.getSpotType());
        vehicle.setParkingTicket(parkingTicket1);
        
        exitPanel.scanAndVacate(parkingTicket1);
        System.out.println("Total cost for car"  + parkingTicket1.getCharge());
	}

}
