package com.shipping.packaging;

public class StandardPackagingFactory extends PackagingFactory {
    @Override
    public Packaging createPackaging() {
        return new Packaging() {
            @Override
            public String getType() {
                return "STANDARD";
            }

            @Override
            public String getDescription() {
                return "Standard cardboard box";
            }
        };
    }
}
