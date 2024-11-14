package com.ps.CustomClasses;

import java.util.HashMap;

public abstract class Topping extends Product {

    private String type;
    private HashMap<Sandwich.Size, Double> sizePrices;

    public Topping(String name, String type, HashMap<Sandwich.Size, Double> sizePrices) {
        super(name, 0);
        this.type = type;
        this.sizePrices = sizePrices;
    }

    public String getName() {
        return super.getName();
    }

    public void setName(String name) {
        super.setName(name);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public HashMap<Sandwich.Size, Double> getSizePrices() {
        return sizePrices;
    }

    public void setSizePrices(HashMap<Sandwich.Size, Double> sizePrices) {
        this.sizePrices = sizePrices;
    }

    public double calculatePrice(Sandwich.Size size) {
        return sizePrices.getOrDefault(size, 0.0);
    }
}