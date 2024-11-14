package com.ps.CustomClasses;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Order {

    private List<Product> products;
    private HashMap<Product, Double> productPrices;

    public Order() {
        products = new ArrayList<>();
        productPrices = new HashMap<>();
    }

    public Order(String name, List<Sandwich> sandwiches, List<Chips> chips, List<Drink> drinks) {
        this();

        products.addAll(sandwiches);
        products.addAll(chips);
        products.addAll(drinks);
    }

    public void addProduct(Product product) {
        products.add(product);
        productPrices.put(product, product.calculatePrice());
    }

    public double calculateTotal() {
        double totalPrice = 0;

        for (Product product : products) {
            totalPrice += productPrices.getOrDefault(product, 0.0);
        }

        return totalPrice;
    }

    public List<Product> getProducts() {
        return products;
    }

    @Override
    public String toString() {
        StringBuilder orderDetails = new StringBuilder();

        for (Product product : products) {
            orderDetails.append(product.getName()).append(": $")
                    .append(productPrices.getOrDefault(product, 0.0)).append("\n");
        }

        orderDetails.append("Total: $").append(calculateTotal());

        return orderDetails.toString();
    }
}
