package com.shipping.pricing;

import com.shipping.model.ShippingOrder;

public class ItemTypePricingHandler extends PricingHandler {
    @Override
    public double handle(ShippingOrder order, double currentPrice) {
        double itemTypeFees;
        switch (order.getItemType()) {
            case "FRAGILE":
                itemTypeFees = 20.0;
                break;
            case "OVERSIZED":
                itemTypeFees = 50.0;
                break;
            default:
                itemTypeFees = 0.0;
                break;
        }
        double total = currentPrice + itemTypeFees;
        return next != null ? next.handle(order, total) : total;
    }
}
