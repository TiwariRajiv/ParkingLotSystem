package com.parking.lot.pojo;

import com.parking.lot.enums.VehicleType;

public class Vehicle {
    private VehicleType vehicleType;
    private String registrationNumber;
    private String colour;

    public Vehicle(VehicleType vehicleType, String registrationNumber, String colour) {
        this.vehicleType = vehicleType;
        this.registrationNumber = registrationNumber;
        this.colour = colour;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    @Override
    public String toString() {
        return "Vehicle : {\"VehicleType\" : \"" + vehicleType + "\", \"RegistrationNumber\" : \""
                + registrationNumber + "\", \"Colour\" : \"" + colour + "\"}";
    }
}
