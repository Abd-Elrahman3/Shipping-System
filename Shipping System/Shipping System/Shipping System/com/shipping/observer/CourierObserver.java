package com.shipping.observer;

public interface CourierObserver {
    void onVehicleDispatched(String vehicleType, String destination);
}
