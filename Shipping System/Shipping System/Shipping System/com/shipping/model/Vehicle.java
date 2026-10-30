package com.shipping.model;

import java.util.List;

public class Vehicle {
    private final String type;
    private final List<String> allowedCountries;
    private final double maxCapacity;

    public Vehicle(String type, List<String> allowedCountries, double maxCapacity) {
        this.type = type;
        this.allowedCountries = allowedCountries;
        this.maxCapacity = maxCapacity;
    }

    public String getType() {
        return type;
    }

    public List<String> getAllowedCountries() {
        return allowedCountries;
    }

    public double getMaxCapacity() {
        return maxCapacity;
    }

    @Override
    public String toString() {
        return "Vehicle{" + "type='" + type + '\'' + ", maxCapacity=" + maxCapacity +'}';
    }
}
