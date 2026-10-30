package com.shipping.state;

import java.util.List;

public interface RegionState {
    List<String> getAllowedVehicles();

    double getMaxWeight();

    String getRequiredDocumentation();
}
