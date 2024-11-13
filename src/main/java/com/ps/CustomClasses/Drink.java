package com.ps.CustomClasses;

public class Drink extends Product {

    private String flavor;
    private Size size;
    // Enum for Sizes
    public enum Size {
        SMALL, MEDIUM, LARGE
    }

    public Drink(String flavor, Size size) {
        super(flavor, 0);
        this.flavor = flavor;
        this.size = size;
    }


    @Override
    public double calculatePrice() {
        double price = 0;


        switch (size) {
            case SMALL:
                price = 2.00;
                break;
            case MEDIUM:
                price = 2.50;
                break;
            case LARGE:
                price = 3.00;
                break;
        }

        return price;
    }


    public String getFlavor() {
        return flavor;
    }


    public Size getSize() {
        return size;
    }
}