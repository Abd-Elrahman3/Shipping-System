package com.shipping.model;

public class ShippingOrder {
    private final String country;
    private final String itemType;
    private final double weight;
    private final double distance;
    private final String deliveryDate;
    private final String vehicleType;
    private final String courierName;
    private final String packagingType;

    private ShippingOrder(Builder builder) {
        this.country = builder.country;
        this.itemType = builder.itemType;
        this.weight = builder.weight;
        this.distance = builder.distance;
        this.deliveryDate = builder.deliveryDate;
        this.vehicleType = builder.vehicleType;
        this.courierName = builder.courierName;
        this.packagingType = builder.packagingType;
    }

    public String getCountry() {
        return country;
    }

    public String getItemType() {
        return itemType;
    }

    public double getWeight() {
        return weight;
    }

    public double getDistance() {
        return distance;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public String getCourierName() {
        return courierName;
    }

    public String getPackagingType() {
        return packagingType;
    }

    public static class Builder {
        private String country;
        private String itemType;
        private double weight;
        private double distance;
        private String deliveryDate = "STANDARD";
        private String vehicleType;
        private String courierName;
        private String packagingType;

        public Builder country(String country) {
        switch (country.toUpperCase()) {
            case "EGYPT": this.country = "EG"; break;
            case "UAE":   this.country = "AE"; break;
            case "SAUDI ARABIA": this.country = "SA"; break;
            case "EUROPE": this.country = "EU"; break;
            default:      this.country = country.toUpperCase(); break;
        }
        return this;
    } 

        public Builder itemType(String itemType) {
            this.itemType = itemType.toUpperCase();
            return this;
        }

        public Builder weight(double weight) {
            this.weight = weight;
            return this;
        }

        public Builder distance(double distance) {
            this.distance = distance;
            return this;
        }

        public Builder deliveryDate(String deliveryDate) {
            this.deliveryDate = deliveryDate.toUpperCase();
            return this;
        }

        public Builder vehicleType(String vehicleType) {
            this.vehicleType = vehicleType.toUpperCase();
            return this;
        }

        public Builder courierName(String courierName) {
            this.courierName = courierName.substring(0, 1).toUpperCase() + courierName.substring(1).toLowerCase();
            return this;
        }

        public Builder packagingType(String packagingType) {
            this.packagingType = packagingType.toUpperCase();
            return this;
        }

        public ShippingOrder build() {
            if (country == null || itemType == null || vehicleType == null) {
                throw new IllegalStateException("country, itemType, vehicleType are required");
            }
            if (weight <= 0) {
                throw new IllegalStateException("weight must be greater than zero");
            }
            if (distance <= 0) {
                throw new IllegalStateException("distance must be greater than zero");
            }
            return new ShippingOrder(this);
        }
        
    }
}
