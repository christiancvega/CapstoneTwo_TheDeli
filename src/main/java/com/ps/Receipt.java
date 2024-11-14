package com.ps;

import com.ps.CustomClasses.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Receipt {

    private String customerName;
    private LocalDateTime orderDateTime;
    private List<Product> products;
    private double totalPrice;

    public Receipt(String customerName, LocalDateTime orderDateTime, List<Product> products, double totalPrice) {
        this.customerName = customerName;
        this.orderDateTime = orderDateTime;
        this.products = products;
        this.totalPrice = totalPrice;
    }

    public String getCustomerName() {
        return customerName;
    }

    public LocalDateTime getOrderDateTime() {
        return orderDateTime;
    }

    public List<Product> getProducts() {
        return products;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public String getFormattedDateTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH:mm:ss");
        return orderDateTime.format(formatter);
    }

    public String getDateTimeForFile() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");
        return orderDateTime.format(formatter);
    }

    @Override
    public String toString() {
        StringBuilder receipt = new StringBuilder();
        receipt.append("====================================\n");
        receipt.append("        Deli Order Receipt        \n");
        receipt.append("====================================\n\n");

        receipt.append("Customer Name: ").append(customerName).append("\n");
        receipt.append("Order Date and Time: ").append(getFormattedDateTime()).append("\n");

        receipt.append("\n------------------------------------\n");
        receipt.append("Items:\n");
        receipt.append("------------------------------------\n");

        for (Product product : products) {
            receipt.append("\n");
            if (product instanceof Sandwich) {
                Sandwich sandwich = (Sandwich) product;
                receipt.append("Sandwich:\n");
                receipt.append("Size: ").append(sandwich.getSize()).append("\n");
                receipt.append("Bread Type: ").append(sandwich.getBreadType()).append("\n");
                receipt.append("Toasted: ").append(sandwich.isToasted() ? "Yes" : "No").append("\n");

                receipt.append("Toppings:\n");
                for (Topping topping : sandwich.getToppings()) {
                    receipt.append("- ").append(topping.getName()).append("\n");
                }
                receipt.append("Price: $").append(sandwich.calculatePrice()).append("\n");
            } else if (product instanceof Drink) {
                Drink drink = (Drink) product;
                receipt.append(drink.getFlavor()).append(" (").append(drink.getSize()).append(")\n");
                receipt.append("Price: $").append(drink.calculatePrice()).append("\n");
            } else if (product instanceof Chips) {
                Chips chips = (Chips) product;
                receipt.append(chips.getType()).append("\n");
                receipt.append("Price: $").append(chips.calculatePrice()).append("\n");
            }
        }

        receipt.append("\n------------------------------------\n");
        receipt.append("Total Price: $").append(totalPrice).append("\n");
        receipt.append("====================================\n");

        return receipt.toString();
    }
}