package com.parking.lot;

import com.parking.lot.services.ConstructParkingService;
import com.parking.lot.services.DisplayService;
import com.parking.lot.services.ParkingService;
import com.parking.lot.services.factory.ServiceFactory;
import com.parking.lot.enums.VehicleType;
import com.parking.lot.pojo.Parking;
import com.parking.lot.pojo.Vehicle;

import java.util.Scanner;

public class Driver {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to parking lot");
        while (true) {
            try {
                String input = scanner.nextLine();
                String[] inputs = input.split(" ");
                if (inputs[0].equalsIgnoreCase("create_parking_lot")) {
                    ConstructParkingService service = (ConstructParkingService) ServiceFactory.getService("");
                    service.createParking(inputs[1], Integer.parseInt(inputs[2]), Integer.parseInt(inputs[3]));
                } else if (inputs[0].equalsIgnoreCase("park_vehicle")) {
                    ParkingService service = (ParkingService) ServiceFactory.getService(ServiceFactory.PARKING);
                    service.parkVehicle(new Vehicle(VehicleType.valueOf(inputs[1]), inputs[2], inputs[3]));
                } else if (inputs[0].equalsIgnoreCase("unpark_vehicle")) {
                    ParkingService service = (ParkingService) ServiceFactory.getService(ServiceFactory.PARKING);
                    service.unParkVehicle(inputs[1]);
                } else if (inputs[0].equalsIgnoreCase("display")) {
                    DisplayService service = (DisplayService) ServiceFactory.getService(ServiceFactory.DISPLAY);
                    service.printByInput(inputs);
                } else if(inputs[0].equalsIgnoreCase("exit")) {
                    System.out.println(Parking.getInstance());
                    System.out.println("Exiting on user command!!");
                    break;
                } else if (inputs[0].equalsIgnoreCase("")) {
                    //TODO : Nothing
                } else {
                    System.out.println("Invalid input!!! Try again");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
