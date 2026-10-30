package com.shipping.proxy;

import com.shipping.model.ShippingOrder;
import com.shipping.model.Vehicle;
import com.shipping.selection.SelectionStrategy;
import java.util.ArrayList;
import java.util.List;

public class RealVehicleService implements VehicleService {

    private final List<Vehicle> allVehicles = List.of(
        new Vehicle("TRUCK", List.of("EG"), 5000),
        new Vehicle("DRONE", List.of("UAE", "SA", "EG"), 10),
        new Vehicle("VAN",   List.of("EG"), 500),
        new Vehicle("SHIP",  List.of("SA", "UAE", "EU"), 50000),
        new Vehicle("PLANE", List.of("SA", "UAE", "EU", "EG"), 20000)
    );

    @Override
    public List<Vehicle> getAvailableVehicles(ShippingOrder order, List<SelectionStrategy> strategies) {
        System.out.println("[DB] Fetching vehicles for " 
            + order.getCountry() + ", " + order.getWeight() + "kg");

        List<Vehicle> result = new ArrayList<>(allVehicles);

        for (SelectionStrategy strategy : strategies) {
            result = strategy.select(result, order);
        }

        return result;
    }
}
