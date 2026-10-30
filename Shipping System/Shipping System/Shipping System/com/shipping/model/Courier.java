package com.shipping.model;

public interface Courier {
    String getName();

    String deliver(ShippingOrder order);
}
