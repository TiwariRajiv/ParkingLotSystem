package com.parking.lot.enums;

public enum VehicleType {
    BIKE("bike"),
    CAR("car"),
    TRUCK("truck");

    private String name;

    VehicleType(String vehicleType) {
        this.name = vehicleType;
    }

    public String getName() {
        return name;
    }
}
