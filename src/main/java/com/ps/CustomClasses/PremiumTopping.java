package com.ps.CustomClasses;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class PremiumTopping extends Topping {

    private static final HashMap<String, HashMap<Sandwich.Size, Double>> toppingPrices = new HashMap<>();

    static {
        toppingPrices.put("Steak", new HashMap<Sandwich.Size, Double>() {{
            put(Sandwich.Size.SMALL, 1.00);
            put(Sandwich.Size.MEDIUM, 2.00);
            put(Sandwich.Size.LARGE, 3.00);
        }});
        toppingPrices.put("Ham", new HashMap<Sandwich.Size, Double>() {{
            put(Sandwich.Size.SMALL, 1.00);
            put(Sandwich.Size.MEDIUM, 2.00);
            put(Sandwich.Size.LARGE, 3.00);
        }});
        toppingPrices.put("Salami", new HashMap<Sandwich.Size, Double>() {{
            put(Sandwich.Size.SMALL, 1.00);
            put(Sandwich.Size.MEDIUM, 2.00);
            put(Sandwich.Size.LARGE, 3.00);
        }});
        toppingPrices.put("Roast Beef", new HashMap<Sandwich.Size, Double>() {{
            put(Sandwich.Size.SMALL, 1.00);
            put(Sandwich.Size.MEDIUM, 2.00);
            put(Sandwich.Size.LARGE, 3.00);
        }});
        toppingPrices.put("Chicken", new HashMap<Sandwich.Size, Double>() {{
            put(Sandwich.Size.SMALL, 1.00);
            put(Sandwich.Size.MEDIUM, 2.00);
            put(Sandwich.Size.LARGE, 3.00);
        }});
        toppingPrices.put("Bacon", new HashMap<Sandwich.Size, Double>() {{
            put(Sandwich.Size.SMALL, 1.00);
            put(Sandwich.Size.MEDIUM, 2.00);
            put(Sandwich.Size.LARGE, 3.00);
        }});
        toppingPrices.put("American", new HashMap<Sandwich.Size, Double>() {{
            put(Sandwich.Size.SMALL, 0.75);
            put(Sandwich.Size.MEDIUM, 1.50);
            put(Sandwich.Size.LARGE, 2.25);
        }});
        toppingPrices.put("Provolone", new HashMap<Sandwich.Size, Double>() {{
            put(Sandwich.Size.SMALL, 0.75);
            put(Sandwich.Size.MEDIUM, 1.50);
            put(Sandwich.Size.LARGE, 2.25);
        }});
        toppingPrices.put("Cheddar", new HashMap<Sandwich.Size, Double>() {{
            put(Sandwich.Size.SMALL, 0.75);
            put(Sandwich.Size.MEDIUM, 1.50);
            put(Sandwich.Size.LARGE, 2.25);
        }});
        toppingPrices.put("Swiss", new HashMap<Sandwich.Size, Double>() {{
            put(Sandwich.Size.SMALL, 0.75);
            put(Sandwich.Size.MEDIUM, 1.50);
            put(Sandwich.Size.LARGE, 2.25);
        }});
    }

    public PremiumTopping(String name, String type) {
        super(name, type, toppingPrices.get(name));
    }

    @Override
    public double calculatePrice(Sandwich.Size size) {
        HashMap<Sandwich.Size, Double> prices = toppingPrices.get(getName());
        if (prices != null) {
            return prices.getOrDefault(size, 0.0);
        }
        return 0.0;
    }

    @Override
    public double calculatePrice() {

        return 0;
    }

    public static List<PremiumTopping> getPremiumToppings() {
        return Arrays.asList(
                new PremiumTopping("Steak", "Meat"),
                new PremiumTopping("Ham", "Meat"),
                new PremiumTopping("Salami", "Meat"),
                new PremiumTopping("Roast Beef", "Meat"),
                new PremiumTopping("Chicken", "Meat"),
                new PremiumTopping("Bacon", "Meat"),
                new PremiumTopping("American", "Cheese"),
                new PremiumTopping("Provolone", "Cheese"),
                new PremiumTopping("Cheddar", "Cheese"),
                new PremiumTopping("Swiss", "Cheese")
        );
    }
}