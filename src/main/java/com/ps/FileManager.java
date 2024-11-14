package com.ps;

import com.ps.CustomClasses.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileManager {

    private static final String RECEIPTS_FOLDER = "receipts";

    public static void saveReceipt(Receipt receipt) {
        File folder = new File(RECEIPTS_FOLDER);
        if (!folder.exists()) {
            folder.mkdir();
        }

        String fileName = receipt.getDateTimeForFile() + ".txt";
        File receiptFile = new File(RECEIPTS_FOLDER + File.separator + fileName);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(receiptFile))) {
            writer.write("====================================\n");
            writer.write("        Deli Order Receipt        \n");
            writer.write("====================================\n\n");

            writer.write("Customer Name: " + receipt.getCustomerName() + "\n");
            writer.write("Order Date and Time: " + receipt.getFormattedDateTime() + "\n");

            writer.write("\n------------------------------------\n");
            writer.write("Items:\n");
            writer.write("------------------------------------\n");

            for (Product product : receipt.getProducts()) {
                if (product instanceof Sandwich) {
                    Sandwich sandwich = (Sandwich) product;
                    writer.write("\nSandwich:\n");
                    writer.write("Size: " + sandwich.getSize() + "\n");
                    writer.write("Bread Type: " + sandwich.getBreadType() + "\n");
                    writer.write("Toasted: " + (sandwich.isToasted() ? "Yes" : "No") + "\n");

                    writer.write("Toppings:\n");
                    for (Topping topping : sandwich.getToppings()) {
                        writer.write("- " + topping.getName() + "\n");
                    }
                    writer.write("Price: $" + sandwich.calculatePrice() + "\n");
                } else if (product instanceof Drink) {
                    Drink drink = (Drink) product;
                    writer.write("\n" + drink.getFlavor() + " (" + drink.getSize() + ")\n");
                    writer.write("Price: $" + drink.calculatePrice() + "\n");
                } else if (product instanceof Chips) {
                    Chips chips = (Chips) product;
                    writer.write("\n" + chips.getType() + "\n");
                    writer.write("Price: $" + chips.calculatePrice() + "\n");
                }
            }

            writer.write("\n------------------------------------\n");
            writer.write("Total Price: $" + receipt.getTotalPrice() + "\n");
            writer.write("====================================\n");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}