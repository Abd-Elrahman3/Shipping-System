package com.shipping.packaging;

public class FragilePackagingFactory extends PackagingFactory {
    @Override
    public Packaging createPackaging() {
        return new Packaging() {
            @Override
            public String getType() {
                return "FRAGILE";
            }

            @Override
            public String getDescription() {
                return "Bubble-wrap reinforced box";
            }
        };
    }
}
