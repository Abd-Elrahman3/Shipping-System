package com.shipping.pricing;

import com.shipping.model.ShippingOrder;

public class DatePricingHandler extends PricingHandler {
    @Override
    public double handle(ShippingOrder order, double currentPrice) {
        double multiplier = "EXPRESS".equals(order.getDeliveryDate()) ? 1.5 : 1.0;
        double total = currentPrice * multiplier;
        return next != null ? next.handle(order, total) : total;
    }
}
