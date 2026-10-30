package com.shipping.proxy;

import com.shipping.model.ShippingOrder;
import com.shipping.model.Vehicle;
import com.shipping.selection.SelectionStrategy;
import java.util.List;

public interface VehicleService {
    List<Vehicle> getAvailableVehicles(ShippingOrder order, List<SelectionStrategy> strategies);
}
