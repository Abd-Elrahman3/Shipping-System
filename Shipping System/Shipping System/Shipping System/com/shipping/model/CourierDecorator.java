package com.shipping.model;

public abstract class CourierDecorator implements Courier {
    protected final Courier wrapped;

    protected CourierDecorator(Courier courier) {
        this.wrapped = courier;
    }

    @Override
    public String getName() {
        return wrapped.getName();
    }

    @Override
    public String deliver(ShippingOrder order) {
        return wrapped.deliver(order);
    }
}
