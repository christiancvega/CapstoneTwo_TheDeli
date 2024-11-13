package com.ps.CustomClasses;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private List<Product> products;

    public Order() {
        products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public double calculateTotal() {
        double totalPrice = 0;

        for (Product product : products) {
            totalPrice += product.calculatePrice();
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
                    .append(product.calculatePrice()).append("\n");
        }

        orderDetails.append("Total: $").append(calculateTotal());

        return orderDetails.toString();
    }
}
