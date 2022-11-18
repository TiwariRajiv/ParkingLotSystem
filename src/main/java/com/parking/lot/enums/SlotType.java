package com.parking.lot.enums;

public enum SlotType {
    BIKE("bike"),
    CAR("car"),
    TRUCK("truck");

    private final String name;

    SlotType(String slotType) {
        this.name = slotType;
    }

    public String getName() {
        return name;
    }
}
