package com.shipping.facade;

import com.shipping.model.ShippingOrder;
import com.shipping.model.Vehicle;
import com.shipping.observer.AvailableCourier;
import com.shipping.observer.VehicleDispatcher;
import com.shipping.packaging.FragilePackagingFactory;
import com.shipping.packaging.Packaging;
import com.shipping.packaging.PackagingFactory;
import com.shipping.packaging.StandardPackagingFactory;
import com.shipping.pricing.DatePricingHandler;
import com.shipping.pricing.DistancePricingHandler;
import com.shipping.pricing.ItemTypePricingHandler;
import com.shipping.pricing.PricingHandler;
import com.shipping.pricing.WeightPricingHandler;
import com.shipping.proxy.VehicleService;
import com.shipping.proxy.VehicleServiceProxy;
import com.shipping.selection.ByCountrySelectionStrategy;
import com.shipping.selection.ByWeightSelectionStrategy;
import com.shipping.selection.SelectionStrategy;
import com.shipping.state.EgyptState;
import com.shipping.state.EuropeState;
import com.shipping.state.RegionState;
import com.shipping.state.SaudiArabiaState;
import com.shipping.state.ShippingContext;
import com.shipping.state.UAEState;
import java.util.List;

public class ShippingService {
    private final VehicleService vehicleService = new VehicleServiceProxy();
    private final VehicleDispatcher dispatcher = new VehicleDispatcher();
    private final ShippingContext context = new ShippingContext();

    public double calculatePrice(ShippingOrder order) {
        PricingHandler weight = new WeightPricingHandler();
        PricingHandler distance = new DistancePricingHandler();
        PricingHandler date = new DatePricingHandler();
        PricingHandler itemType = new ItemTypePricingHandler();
        weight.setNext(distance).setNext(date).setNext(itemType);
        return weight.handle(order, 0.0);
    }

    public List<Vehicle> getAvailableVehicles(ShippingOrder order) {
    List<SelectionStrategy> strategies = List.of(
        new ByCountrySelectionStrategy(),
        new ByWeightSelectionStrategy()
    );
    return vehicleService.getAvailableVehicles(order, strategies);
    }

    public void dispatchOrder(ShippingOrder order) {
        context.setState(resolveState(order.getCountry()));
        List<String> allowedVehicles = context.getAllowedVehicles();
        if (!allowedVehicles.contains(order.getVehicleType())) {
            throw new IllegalStateException(
                "Vehicle type '" + order.getVehicleType() + "' is not allowed in " 
                + order.getCountry() + ". Allowed: " + allowedVehicles
            );
        }
        if (order.getWeight() > context.getMaxWeight()) {
        throw new IllegalStateException(
            "Order weight " + order.getWeight() + "kg exceeds the limit of "
            + context.getMaxWeight() + "kg for " + order.getCountry()
        );
        }
        System.out.println("Required documentation: " + context.getDocumentation());
        dispatcher.dispatch(order.getVehicleType(), order.getCountry());
    }

    

    public Packaging getPackaging(ShippingOrder order) {
        PackagingFactory factory;
        switch (order.getItemType()) {
            case "FRAGILE":
                factory = new FragilePackagingFactory();
                break;
            default:
                factory = new StandardPackagingFactory();
                break;
        }
        return factory.createPackaging();
    }

    public void registerCourier(AvailableCourier courier) {
        dispatcher.addObserver(courier);
    }

    private RegionState resolveState(String country) {
        switch (country) {
            case "UAE":
                return new UAEState();
            case "EUROPE":
                return new EuropeState();
            case "SAUDI ARABIA":
                return new SaudiArabiaState();
            default:
                return new EgyptState();
        }
    }
}
