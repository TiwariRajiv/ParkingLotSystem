package com.parking.lot.pojo;

import java.util.List;

public class Floor {
    private int number;
    private List<Slot> slots;

    public Floor(int number, List<Slot> slots) {
        this.number = number;
        this.slots = slots;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public List<Slot> getSlots() {
        return slots;
    }

    public void setSlots(List<Slot> slots) {
        this.slots = slots;
    }

    @Override
    public String toString() {
        return "Floor : {\"FloorId\" : \"" + number + "\", \"Slots\" : \"" + slots.size() + "\"}";
    }
}
