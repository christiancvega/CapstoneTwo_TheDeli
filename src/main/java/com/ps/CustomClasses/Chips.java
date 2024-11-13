package com.ps.CustomClasses;

public class Chips extends Product {

    private String type;


    public Chips(String type) {
        super(type, 1.50);
        this.type = type;
    }


    @Override
    public double calculatePrice() {
        return 1.50;  // Fixed price for chips
    }


    public String getType() {
        return type;
    }


    @Override
    public String getName() {
        return "Chips: " + type;
    }


}