package com.shipping.state;

import java.util.List;

public class EgyptState implements RegionState {
    @Override
    public List<String> getAllowedVehicles() {
        return List.of("TRUCK", "VAN", "PLANE", "DRONE");
    }

    @Override
    public double getMaxWeight() {
        return 10000.0;
    }

    @Override
    public String getRequiredDocumentation() {
        return "Customs form EG-01";
    }
}
