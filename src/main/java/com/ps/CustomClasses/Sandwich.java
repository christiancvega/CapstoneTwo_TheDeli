package com.ps.CustomClasses;

import java.util.List;

public class Sandwich extends Product {
    private List<Topping> toppings;
    private boolean isToasted;
    private boolean extraCheese;
    private boolean extraMeat;
    private Size size;
    private BreadTypes breadType;

    public enum BreadTypes {
        WHITE, WHEAT, RYE, WRAP
    }

    public enum Size {
        SMALL, MEDIUM, LARGE
    }

    public Sandwich(String name, Size size, BreadTypes breadType, List<Topping> toppings, boolean isToasted, boolean extraMeat, boolean extraCheese) {
        super(name, 0);
        this.size = size;
        this.breadType = breadType;
        this.toppings = toppings;
        this.isToasted = isToasted;
        this.extraMeat = extraMeat;
        this.extraCheese = extraCheese;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    @Override
    public double calculatePrice() {
        double totalPrice = super.getPriceValue();

        switch (size) {
            case SMALL:
                totalPrice = 5.50;
                break;
            case MEDIUM:
                totalPrice = 7.00;
                break;
            case LARGE:
                totalPrice = 8.50;
                break;
        }

        if (extraMeat) {
            totalPrice += (size == Size.SMALL) ? 0.50 : (size == Size.MEDIUM) ? 1.00 : 1.50;
        }
        if (extraCheese) {
            totalPrice += (size == Size.SMALL) ? 0.30 : (size == Size.MEDIUM) ? 0.60 : 0.90;
        }
        for (Topping topping : toppings) {
            totalPrice += topping.calculatePrice();
        }

        return totalPrice;
    }
}

