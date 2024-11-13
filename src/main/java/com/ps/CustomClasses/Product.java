package com.ps.CustomClasses;

public abstract class Product {
    // create and declare product variables
    String name;
    double price;
// constructor to create product
    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
    // abstract method to inherit custom pricing to child classes
    public abstract double getPrice();
// getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPriceValue(){
        return price;
    }

    @Override
    public String toString() {
        return name + ": $" + price;
    }
}
