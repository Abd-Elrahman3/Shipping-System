package com.shipping.model;

import java.util.ArrayList;
import java.util.List;

public class ReviewableCourier extends CourierDecorator {
    private final List<String> reviews = new ArrayList<>();
    private double totalRating = 0.0;
    private int ratingCount = 0;

    public ReviewableCourier(Courier courier) {
        super(courier);
    }

    public void addReview(String review, double rating) {
        reviews.add(review);
        totalRating += rating;
        ratingCount++;
    }

    public double getAverageRating() {
        return ratingCount == 0 ? 0.0 : totalRating / ratingCount;
    }

    public List<String> getReviews() {
        return reviews;
    }

    @Override
    public String deliver(ShippingOrder order) {
        String result = super.deliver(order);
        if (ratingCount == 0) return result;
        return result + " [Rated: " + String.format("%.1f", getAverageRating()) + "/5]";
    }
}
