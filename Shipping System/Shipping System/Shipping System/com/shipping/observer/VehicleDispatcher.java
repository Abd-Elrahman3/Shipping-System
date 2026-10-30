package com.shipping.observer;

import java.util.ArrayList;
import java.util.List;

public class VehicleDispatcher implements VehicleSubject {
    private final List<CourierObserver> observers = new ArrayList<>();

    @Override
    public void addObserver(CourierObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(CourierObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String vehicleType, String destination) {
        for (CourierObserver observer : observers) {
            observer.onVehicleDispatched(vehicleType, destination);
        }
    }

    public void dispatch(String vehicleType, String destination) {
        System.out.println("Dispatching " + vehicleType + " to " + destination);
        notifyObservers(vehicleType, destination);
    }
}
