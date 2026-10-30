import com.shipping.facade.ShippingService;
import com.shipping.model.BasicCourier;
import com.shipping.model.Courier;
import com.shipping.model.ReviewableCourier;
import com.shipping.model.ShippingOrder;
import com.shipping.model.Vehicle;
import com.shipping.observer.AvailableCourier;
import com.shipping.packaging.Packaging;
import java.util.List;
import java.util.Scanner;



public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        ShippingService service = new ShippingService();

        service.registerCourier(new AvailableCourier("Ahmed"));
        service.registerCourier(new AvailableCourier("Sara"));
        service.registerCourier(new AvailableCourier("John"));
        service.registerCourier(new AvailableCourier("Emily"));
        
        System.out.println("Enter order details: country, item type, delivery date, vehicle type, courier name, review, packaging, weight, distance, rating");
        String country = in.nextLine(),
            itemType = in.nextLine(),
            deliveryDate = in.nextLine(),
            vehicleType = in.nextLine(),
            courierName = in.nextLine(),
            review = in.nextLine(),
            packagingType = in.nextLine();
        double weight = in.nextDouble(),
            distance = in.nextDouble(),
            rating = in.nextDouble();

        

        ShippingOrder order = new ShippingOrder.Builder()
            .country(country)
            .itemType(itemType)
            .weight(weight)
            .distance(distance)
            .deliveryDate(deliveryDate)
            .vehicleType(vehicleType)
            .courierName(courierName)
            .packagingType(packagingType)
            .build();

        List<Vehicle> vehicles = service.getAvailableVehicles(order);
        System.out.println("Available: " + vehicles);

        double price = service.calculatePrice(order);
        System.out.println("Price: $" + price);

        Packaging packaging = service.getPackaging(order);
        System.out.println("Packaging: " + packaging.getDescription());

        service.dispatchOrder(order);

        Courier courier = new BasicCourier(courierName);
        ReviewableCourier reviewed = new ReviewableCourier(courier);
        System.out.println(reviewed.deliver(order));
        System.out.println("Rating: " + reviewed.getAverageRating());
        
        

        reviewed.addReview(review, rating);
        in.close();
    }

}
