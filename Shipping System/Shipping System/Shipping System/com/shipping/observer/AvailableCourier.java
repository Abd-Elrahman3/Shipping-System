package com.shipping.observer;

public class AvailableCourier implements CourierObserver {
    private final String name;

    public AvailableCourier(String name) {
        this.name = name;
    }

    @Override
    public void onVehicleDispatched(String vehicleType, String destination) {
        System.out.println(name + " notified: " + vehicleType + " going to " + destination);
    }
}
