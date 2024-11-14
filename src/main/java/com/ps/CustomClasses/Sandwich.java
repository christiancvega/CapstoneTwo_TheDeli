package com.ps.CustomClasses;

import com.ps.CustomClasses.Product;
import com.ps.CustomClasses.Topping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Sandwich extends Product {
    private List<Topping> toppings;
    private boolean isToasted;
    private boolean extraMeat;
    private boolean extraCheese;
    private Size size;
    private BreadTypes breadType;

    public enum BreadTypes {
        WHITE, WHEAT, RYE, WRAP
    }

    public enum Size {
        SMALL, MEDIUM, LARGE
    }

    private static final HashMap<Size, Double> basePrices = new HashMap<Size, Double>() {{
        put(Size.SMALL, 5.50);
        put(Size.MEDIUM, 7.00);
        put(Size.LARGE, 8.50);
    }};

    private static final HashMap<Size, Double> extraMeatPrices = new HashMap<Size, Double>() {{
        put(Size.SMALL, 0.50);
        put(Size.MEDIUM, 1.00);
        put(Size.LARGE, 1.50);
    }};

    private static final HashMap<Size, Double> extraCheesePrices = new HashMap<Size, Double>() {{
        put(Size.SMALL, 0.30);
        put(Size.MEDIUM, 0.60);
        put(Size.LARGE, 0.90);
    }};

    public Sandwich(List<Topping> toppings, boolean extraMeat, boolean extraCheese, Size size, BreadTypes breadType, boolean isToasted) {
        super("Sandwich", 0);
        this.toppings = toppings;
        this.extraMeat = extraMeat;
        this.extraCheese = extraCheese;
        this.size = size;
        this.breadType = breadType;
        this.isToasted = isToasted;
    }

    public Size getSize() {
        return size;
    }

    public BreadTypes getBreadType() {
        return breadType;
    }

    public List<Topping> getToppings() {
        return toppings;
    }

    public boolean isToasted() {
        return isToasted;
    }

    @Override
    public double calculatePrice() {
        double basePrice = basePrices.getOrDefault(size, 0.0);

        for (Topping topping : toppings) {
            basePrice += topping.calculatePrice();
        }

        if (extraMeat) {
            basePrice += extraMeatPrices.getOrDefault(size, 0.0);
        }

        if (extraCheese) {
            basePrice += extraCheesePrices.getOrDefault(size, 0.0);
        }

        return basePrice;
    }
}