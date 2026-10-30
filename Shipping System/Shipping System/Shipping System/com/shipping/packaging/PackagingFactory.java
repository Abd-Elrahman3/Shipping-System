package com.shipping.packaging;

public abstract class PackagingFactory {
    public abstract Packaging createPackaging();

    public String preparePackaging() {
        Packaging packaging = createPackaging();
        return "Prepared: " + packaging.getDescription();
    }
}
