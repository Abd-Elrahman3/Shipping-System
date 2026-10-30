package com.shipping.model;

public class BasicCourier implements Courier {
    private final String name;

    public BasicCourier(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String deliver(ShippingOrder order) {
        return name + " delivered order to " + order.getCountry();
    }
}
