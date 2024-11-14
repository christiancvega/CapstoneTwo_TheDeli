package com.ps.CustomClasses;

import java.util.HashMap;

public class Drink extends Product {

    private String flavor;
    private Size size;

    public enum Size {
        SMALL, MEDIUM, LARGE
    }

    public enum Flavor {
        COKE, SPRITE, FANTA
    }

    public Drink(String flavor, Size size) {
        super(flavor, 0);
        this.flavor = flavor;
        this.size = size;
    }

    @Override
    public double calculatePrice() {
        HashMap<Size, Double> sizePriceMap = new HashMap<>();
        sizePriceMap.put(Size.SMALL, 2.00);
        sizePriceMap.put(Size.MEDIUM, 2.50);
        sizePriceMap.put(Size.LARGE, 3.00);

        return sizePriceMap.getOrDefault(size, 0.0);
    }

    public String getFlavor() {
        return flavor;
    }

    public Size getSize() {
        return size;
    }

    public static String[] getAvailableFlavors() {

        return new String[]{"Coke", "Sprite", "Fanta"};
    }
}