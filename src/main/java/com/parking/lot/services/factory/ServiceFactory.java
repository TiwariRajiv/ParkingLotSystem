package com.parking.lot.services.factory;

import com.parking.lot.services.ChargingService;
import com.parking.lot.services.ConstructParkingService;
import com.parking.lot.services.DisplayService;
import com.parking.lot.services.ParkingService;
import com.parking.lot.services.Service;

import java.util.HashMap;
import java.util.Map;

public class ServiceFactory {
    public static final String CHARGING = "charging";
    public static final String PARKING = "parking";
    public static final String DISPLAY = "display";
    public static final String CREATE = "create";
    private static Map<String, Service> serviceMap = new HashMap<>();

    static {
        serviceMap.put(PARKING, new ParkingService());
        serviceMap.put(DISPLAY, new DisplayService());
        serviceMap.put(CHARGING, new ChargingService());
        serviceMap.put(CREATE, new ConstructParkingService());
    }

    private ServiceFactory() {}

    public static Service getService(String type) {
        return serviceMap.getOrDefault(type, serviceMap.get(CREATE));
    }
}
