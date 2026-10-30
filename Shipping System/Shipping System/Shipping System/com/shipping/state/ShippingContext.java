package com.shipping.state;

import java.util.List;

public class ShippingContext {
    private RegionState state;

    public void setState(RegionState state) {
        this.state = state;
    }

    public List<String> getAllowedVehicles() {
        return state.getAllowedVehicles();
    }

    public double getMaxWeight() {
        return state.getMaxWeight();
    }

    public String getDocumentation() {
        return state.getRequiredDocumentation();
    }
}
