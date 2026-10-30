package com.shipping.selection;

import com.shipping.model.ShippingOrder;
import com.shipping.model.Vehicle;
import java.util.List;

public interface SelectionStrategy {
    List<Vehicle> select(List<Vehicle> allVehicles, ShippingOrder order);
}