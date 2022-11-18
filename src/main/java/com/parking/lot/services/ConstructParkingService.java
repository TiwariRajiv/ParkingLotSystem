package com.parking.lot.services;

import com.parking.lot.enums.SlotType;
import com.parking.lot.pojo.Floor;
import com.parking.lot.pojo.Parking;
import com.parking.lot.pojo.Slot;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ConstructParkingService implements Service {

    public void createParking(String parkingId, int numOfFloors, int slotsPerFloor) {
        Parking parking = Parking.getInstance();
        parking.setParkingId(parkingId);
        List<Floor> floors = new ArrayList<>();
        for (int i=1; i<=numOfFloors; i++) {
            List<Slot> slots = new ArrayList<>();
            for (int j=1; j<=1 && j<=slotsPerFloor; j++) {
                slots.add(new Slot(j, SlotType.TRUCK, false));
            }
            for (int j=2; j<=3 && j<=slotsPerFloor; j++) {
                slots.add(new Slot(j, SlotType.BIKE, false));
            }
            for (int j=4; j<=slotsPerFloor; j++) {
                slots.add(new Slot(j, SlotType.CAR, false));
            }
            floors.add(new Floor(i, slots));
        }
        parking.setFloors(floors);
        System.out.println("Created parking with " + numOfFloors + " floors and " + slotsPerFloor + " slots per floor");
    }

    public void addFloor() {
        Parking parking = Parking.getInstance();
        int floorNumber = parking.getFloors().size()+1;
        parking.getFloors().add(new Floor(floorNumber, new ArrayList<>()));
    }

    public void addSlot(int floorNumber, Slot slot) {
        Optional<Floor> floor = Parking.getInstance().getFloors().stream().filter(x -> x.getNumber()==floorNumber).findFirst();
        if (!floor.isPresent()) {
            System.out.println("Invalid floor number!!");
            return;
        }
        floor.get().getSlots().add(slot);
    }

}
