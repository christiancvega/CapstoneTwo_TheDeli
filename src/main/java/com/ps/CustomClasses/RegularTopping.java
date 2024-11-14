package com.ps.CustomClasses;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class RegularTopping extends Topping {

    public static List<Topping> regularToppings = Arrays.asList(
            new RegularTopping("Lettuce", "Veggie"),
            new RegularTopping("Tomato", "Veggie"),
            new RegularTopping("Onion", "Veggie"),
            new RegularTopping("Peppers", "Veggie"),
            new RegularTopping("Jalapenos", "Veggie"),
            new RegularTopping("Cucumbers", "Veggie"),
            new RegularTopping("Pickles", "Veggie"),
            new RegularTopping("Guacamole", "Veggie"),
            new RegularTopping("Mushrooms", "Veggie"),
            new RegularTopping("Mayo", "Sauce"),
            new RegularTopping("Mustard", "Sauce"),
            new RegularTopping("Ketchup", "Sauce"),
            new RegularTopping("Ranch", "Sauce"),
            new RegularTopping("Thousand islands", "Sauce"),
            new RegularTopping("Vinaigrette", "Sauce")
    );

    public RegularTopping(String name, String type) {

        super(name, type, createSizePrices());
    }

    private static HashMap<Sandwich.Size, Double> createSizePrices() {
        HashMap<Sandwich.Size, Double> sizePrices = new HashMap<>();
        sizePrices.put(Sandwich.Size.SMALL, 0.0);
        sizePrices.put(Sandwich.Size.MEDIUM, 0.0);
        sizePrices.put(Sandwich.Size.LARGE, 0.0);
        return sizePrices;
    }

    @Override
    public double calculatePrice(Sandwich.Size size) {
        return 0.0;
    }

    @Override
    public double calculatePrice() {
        return 0.0;
    }

    public static List<Topping> getRegularToppings() {
        return (List<Topping>) (List<?>) regularToppings;
    }
}

