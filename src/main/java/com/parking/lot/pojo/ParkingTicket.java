package com.parking.lot.pojo;

public class ParkingTicket {
    private String id;
    private Slot slot;
    private int floor;
    private Vehicle vehicle;
    private long startTime;
    private long endTime;

    public ParkingTicket() {

    }

    public ParkingTicket(String id, Slot slot, int floor, Vehicle vehicle, long startTime, long endTime) {
        this.id = id;
        this.slot = slot;
        this.floor = floor;
        this.vehicle = vehicle;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Slot getSlot() {
        return slot;
    }

    public void setSlot(Slot slot) {
        this.slot = slot;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "Parking Ticket : {\"TicketId\" : \"" + id + "\", \"Slot\" : \"" + slot + ", \"Floor\" : \"" + floor + "\"}";
    }
}
