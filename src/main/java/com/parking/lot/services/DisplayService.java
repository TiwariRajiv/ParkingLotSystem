package com.parking.lot.services;

import com.parking.lot.enums.VehicleType;
import com.parking.lot.pojo.Floor;
import com.parking.lot.pojo.Parking;
import com.parking.lot.pojo.Slot;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class DisplayService implements Service {

    private static final Logger logger = LogManager.getLogManager().getLogger(DisplayService.class.toString());

    public void printByInput(String[] inputs) {
        if (inputs[1].equalsIgnoreCase("free_count")) {
            printFreeSlotCountPerFloor(VehicleType.valueOf(inputs[2].toUpperCase()));
        } else if (inputs[1].equalsIgnoreCase("free_slots")) {
            printFreeSlotsPerFloor(VehicleType.valueOf(inputs[2].toUpperCase()));
        } else if (inputs[1].equalsIgnoreCase("occupied_slots")) {
            printOccupiedSlotsPerFloor(VehicleType.valueOf(inputs[2].toUpperCase()));
        } else {
            System.out.println("Invalid input!!!");
            //logger.info("Invalid input!!!");
        }
    }

    public void printFreeSlotCountPerFloor(VehicleType vehicleType) {
        Parking parking = Parking.getInstance();
        System.out.println("=================================");
        if (Objects.isNull(parking.getFloors())) {
            System.out.println("Parking lot under construction!!");
            return;
        }
        for (Floor floor : parking.getFloors()) {
            int count = 0;
            for (Slot slot : floor.getSlots()) {
                if (!slot.isFull() && slot.getSlotType().getName().equalsIgnoreCase(vehicleType.getName())) {
                    count++;
                }
            }
            System.out.println("Free slots for " + vehicleType +" on floor " + floor.getNumber() + " : " + count);
        }
        System.out.println();
    }

    public void printFreeSlotsPerFloor(VehicleType vehicleType) {
        Parking parking = Parking.getInstance();
        System.out.println("=================================");
        if (Objects.isNull(parking.getFloors())) {
            System.out.println("Parking lot under construction!!");
            return;
        }
        for (Floor floor : parking.getFloors()) {
            List<Integer> list = new ArrayList<>();
            for (Slot slot : floor.getSlots()) {
                if (!slot.isFull() && slot.getSlotType().getName().equalsIgnoreCase(vehicleType.getName())) {
                    list.add(slot.getId());
                }
            }
            System.out.println("Free slots for " + vehicleType +" on floor " + floor.getNumber() + " : " + list);
        }
        System.out.println();
    }

    public void printOccupiedSlotsPerFloor(VehicleType vehicleType) {
        Parking parking = Parking.getInstance();
        System.out.println("=================================");
        if (Objects.isNull(parking.getFloors())) {
            System.out.println("Parking lot under construction!!");
            return;
        }
        for (Floor floor : parking.getFloors()) {
            List<Integer> list = new ArrayList<>();
            for (Slot slot : floor.getSlots()) {
                if (slot.isFull() && slot.getSlotType().getName().equalsIgnoreCase(vehicleType.getName())) {
                    list.add(slot.getId());
                }
            }
            System.out.println("Occupied slots for " + vehicleType +" on floor " + floor.getNumber() + " : " + list);
        }
        System.out.println();
    }
}
