package com.parking.lot.services;

import com.parking.lot.util.Pair;
import com.parking.lot.services.factory.ServiceFactory;
import com.parking.lot.pojo.Floor;
import com.parking.lot.pojo.Parking;
import com.parking.lot.pojo.ParkingTicket;
import com.parking.lot.pojo.Slot;
import com.parking.lot.pojo.Vehicle;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ParkingService implements Service {

    private final Map<String, ParkingTicket> parkingTickets = new HashMap<>();

    public void parkVehicle(Vehicle vehicle) {
        Pair<Integer, Slot> pair = fetchFreeParkingSlot(vehicle);
        if (Objects.isNull(pair)) {
            System.out.println("Parking is full!!");
            return;
        }
        pair.getSecond().setFull(true);
        ParkingTicket parkingTicket = generateParkingTicket(pair.getSecond(), pair.getFirst(), vehicle);
        parkingTickets.put(parkingTicket.getId(), parkingTicket);
        System.out.println("Parked vehicle | " + parkingTicket);
    }

    public void unParkVehicle(String parkingTicketId) {
        ParkingTicket parkingTicket = parkingTickets.get(parkingTicketId);
        if (Objects.isNull(parkingTicket)) {
            System.out.println("Invalid parking ticket Id!!");
            return;
        }
        System.out.println("Unparked : " + parkingTicket);
        parkingTickets.get(parkingTicketId).getSlot().setFull(false);
        parkingTickets.remove(parkingTicketId);
        parkingTicket.setEndTime(System.currentTimeMillis());
        ChargingService service = (ChargingService) ServiceFactory.getService(ServiceFactory.CHARGING);
        service.calculateCharges(parkingTicket);
    }

    private ParkingTicket generateParkingTicket(Slot slot, int floor, Vehicle vehicle) {
        String parkingTicketNumber = Parking.getInstance().getParkingId()  + "_" + floor + "_" + slot.getId();
        return new ParkingTicket(parkingTicketNumber, slot, floor, vehicle, System.currentTimeMillis(), -1);
    }

    private Pair<Integer, Slot> fetchFreeParkingSlot(Vehicle vehicle) {
        Slot freeSlot = null;
        int floorNumber = -1;
        Parking parking = Parking.getInstance();
        for (Floor floor : parking.getFloors()) {
            for (Slot slot : floor.getSlots()) {
                if (!slot.isFull() && slot.getSlotType().getName().equals(vehicle.getVehicleType().getName())) {
                    freeSlot = slot;
                    floorNumber = floor.getNumber();
                    break;
                }
            }
            if (Objects.nonNull(freeSlot)) {
                break;
            }
        }
        if (Objects.isNull(freeSlot)) {
            return null;
        }
        return new Pair<>(floorNumber, freeSlot);
    }
}
