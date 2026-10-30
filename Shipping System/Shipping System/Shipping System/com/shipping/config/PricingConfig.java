package com.shipping.config;

public class PricingConfig {
    private static PricingConfig instance;
    private double pricePerKg = 2.5;
    private double pricePerKm = 0.5;

    private PricingConfig() {
    }

    public static synchronized PricingConfig getInstance() {
        if (instance == null) {
            instance = new PricingConfig();
        }
        return instance;
    }

    public double getPricePerKg() {
        return pricePerKg;
    }

    public double getPricePerKm() {
        return pricePerKm;
    }

    public void setPricePerKg(double pricePerKg) {
        this.pricePerKg = pricePerKg;
    }

    public void setPricePerKm(double pricePerKm) {
        this.pricePerKm = pricePerKm;
    }
}
