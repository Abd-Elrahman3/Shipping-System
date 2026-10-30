package com.shipping.pricing;

import com.shipping.config.PricingConfig;
import com.shipping.model.ShippingOrder;

public class DistancePricingHandler extends PricingHandler {
    @Override
    public double handle(ShippingOrder order, double currentPrice) {
        double added = order.getDistance() * PricingConfig.getInstance().getPricePerKm();
        double total = currentPrice + added;
        return next != null ? next.handle(order, total) : total;
    }
}
