package com.ps.CustomClasses;

public class Topping {

    private String name;
    private double price;
    private boolean isPremium;


    public Topping(String name, double price, boolean isPremium) {
        this.name = name;
        this.price = price;
        this.isPremium = isPremium;
    }


    public double calculatePrice() {
        return isPremium ? price : 0.00;  // If the topping is premium, return its price; otherwise, return 0
    }


    public String getName() {
        return name;
    }


    public double getPrice() {
        return price;
    }


    public void setPrice(double price) {
        this.price = price;
    }


    public boolean isPremium() {
        return isPremium;
    }
}
