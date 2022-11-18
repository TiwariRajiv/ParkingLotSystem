package com.parking.lot.pojo;

import java.util.List;
import java.util.Objects;

public class Parking {
    private volatile String parkingId;
    private volatile List<Floor> floors;
    private static Parking instance;

    public static Parking getInstance() {
        if (Objects.isNull(instance)) {
            synchronized (Parking.class) {
                if (Objects.isNull(instance)) {
                    instance = new Parking();
                }
            }
        }
        return instance;
    }

    public Parking() {

    }
    public Parking(String parkingId, List<Floor> floors) {
        this.parkingId = parkingId;
        this.floors = floors;
    }

    public String getParkingId() {
        return parkingId;
    }

    public void setParkingId(String parkingId) {
        this.parkingId = parkingId;
    }

    public List<Floor> getFloors() {
        return floors;
    }

    public void setFloors(List<Floor> floors) {
        this.floors = floors;
    }

    @Override
    public String toString() {
        return "Parking : {\"ParkingId\" : \"" + parkingId + "\", \"Floors\" : \"" + floors.size() + "\"}";
    }
}
