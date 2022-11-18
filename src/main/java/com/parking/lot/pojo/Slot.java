package com.parking.lot.pojo;

import com.parking.lot.enums.SlotType;

public class Slot {
    private int id;
    private SlotType slotType;
    private boolean isFull;

    public Slot(int id, SlotType slotType, boolean isFull) {
        this.id = id;
        this.slotType = slotType;
        this.isFull = isFull;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public SlotType getSlotType() {
        return slotType;
    }

    public void setSlotType(SlotType slotType) {
        this.slotType = slotType;
    }

    public boolean isFull() {
        return isFull;
    }

    public void setFull(boolean full) {
        isFull = full;
    }

    @Override
    public String toString() {
        return "Slot : {\"SlotId\" : \"" + id + "\", \"SlotType\" : \"" + slotType + "\", \"Full\" : \"" + isFull + "\"}";
    }
}
