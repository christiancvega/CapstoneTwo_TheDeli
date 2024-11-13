package com.ps.CustomClasses;

public abstract class Product {
    String name;
    double price;


    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPriceValue() {
        return price;
    }

    public abstract double calculatePrice();
}
