package com.shipping.state;

import java.util.List;

public class EuropeState implements RegionState {
    @Override
    public List<String> getAllowedVehicles() {
        return List.of("PLANE", "SHIP");
    }

    @Override
    public double getMaxWeight() {
        return 10000.0;
    }

    @Override
    public String getRequiredDocumentation() {
        return "EU customs declaration";
    }
}
