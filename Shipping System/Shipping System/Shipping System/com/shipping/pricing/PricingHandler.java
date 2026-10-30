package com.shipping.pricing;

import com.shipping.model.ShippingOrder;

public abstract class PricingHandler {
    protected PricingHandler next;

    public PricingHandler setNext(PricingHandler next) {
        this.next = next;
        return next;
    }

    public abstract double handle(ShippingOrder order, double currentPrice);
}
