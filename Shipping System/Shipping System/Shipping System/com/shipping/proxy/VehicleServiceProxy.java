package com.shipping.proxy;

import com.shipping.model.ShippingOrder;
import com.shipping.model.Vehicle;
import com.shipping.selection.SelectionStrategy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VehicleServiceProxy implements VehicleService {
    private final RealVehicleService real = new RealVehicleService();
    private final Map<String, List<Vehicle>> cache = new HashMap<>();

    @Override
    public List<Vehicle> getAvailableVehicles(ShippingOrder order, List<SelectionStrategy> strategies) {
        String key = order.getCountry() + "_" + order.getWeight();

        if (cache.containsKey(key)) {
            System.out.println("[Cache] Hit for " + key);
            return cache.get(key);
        }

        List<Vehicle> result = real.getAvailableVehicles(order, strategies);
        cache.put(key, result);
        return result;
    }
}
