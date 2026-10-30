package com.shipping.observer;

public interface VehicleSubject {
    void addObserver(CourierObserver observer);

    void removeObserver(CourierObserver observer);

    void notifyObservers(String vehicleType, String destination);
}
