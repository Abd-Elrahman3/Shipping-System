package com.shipping.pricing;

import com.shipping.config.PricingConfig;
import com.shipping.model.ShippingOrder;

public class WeightPricingHandler extends PricingHandler {
    @Override
    public double handle(ShippingOrder order, double currentPrice) {
        double added = order.getWeight() * PricingConfig.getInstance().getPricePerKg();
        double total = currentPrice + added;
        return next != null ? next.handle(order, total) : total;
    }
}
