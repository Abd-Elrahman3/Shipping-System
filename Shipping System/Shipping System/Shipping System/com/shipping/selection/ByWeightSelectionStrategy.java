package com.shipping.selection;

import com.shipping.model.ShippingOrder;
import com.shipping.model.Vehicle;

import java.util.List;
import java.util.stream.Collectors;

public class ByWeightSelectionStrategy implements SelectionStrategy {
    @Override
    public List<Vehicle> select(List<Vehicle> allVehicles, ShippingOrder order) {
        return allVehicles.stream()
            .filter(v -> v.getMaxCapacity() >= order.getWeight())
            .collect(Collectors.toList());
    }
}