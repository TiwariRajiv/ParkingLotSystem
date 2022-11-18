package com.parking.lot.services;

import com.parking.lot.enums.VehicleType;
import com.parking.lot.pojo.ParkingTicket;

public class ChargingService implements Service {

    public static final int BIKE = 5;
    public static final int CAR = 10;
    public static final int TRUCK = 15;

    public void calculateCharges(ParkingTicket parkingTicket) {
        VehicleType vehicleType = parkingTicket.getVehicle().getVehicleType();
        int chargePerHour = fetchChargePerHour(vehicleType);
        long duration = parkingTicket.getEndTime() - parkingTicket.getStartTime();
        long hours = duration/1000/60/60;
        float charges = (float) (hours + 1) * chargePerHour;
        System.out.println("Charges : " + charges);
    }

    private int fetchChargePerHour(VehicleType vehicleType) {
        if (vehicleType.getName().equalsIgnoreCase("bike")) {
            return BIKE;
        } else if (vehicleType.getName().equalsIgnoreCase("car")) {
            return CAR;
        }
        return TRUCK;
    }
}
