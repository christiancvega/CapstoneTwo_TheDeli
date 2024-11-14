package com.ps;

import com.ps.CustomClasses.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.time.LocalDateTime;

public class UserInterface {

    private static Scanner commandScanner = new Scanner(System.in);
    private static Scanner inputScanner = new Scanner(System.in);
    private static List<Sandwich> sandwiches = new ArrayList<>();
    private static List<Drink> drinks = new ArrayList<>();
    private static List<Chips> chips = new ArrayList<>();
    private static double totalPrice = 0.0;
    private static String name;
    public static Order order;

    public static void display() {
        showMainMenu();
    }

    public static void showMainMenu() {
        int mainMenuCommand;
        do {
            System.out.println("=======================================");
            System.out.println("          Welcome to Deli-cious!       ");
            System.out.println("=======================================");
            System.out.println("Would you like to place an order?");
            System.out.println("1. Yes");
            System.out.println("2. No");
            mainMenuCommand = commandScanner.nextInt();
            switch (mainMenuCommand) {
                case 1:
                    processStartAnOrder();
                    break;
                case 2:
                    System.out.println("Exiting...Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter 1 or 2.");
            }
        } while (mainMenuCommand != 2);
    }

    private static void processStartAnOrder() {
        int startCommand = 0;
        do {
            System.out.println("\n=======================================");
            System.out.println("      What would you like to order?");
            System.out.println("=======================================");
            System.out.println("1. Add a Sandwich");
            System.out.println("2. Add a Drink");
            System.out.println("3. Add Chips");
            System.out.println("4. Finish the Order");
            startCommand = commandScanner.nextInt();
            switch (startCommand) {
                case 1:
                    processAddASandwich();
                    break;
                case 2:
                    processAddADrink();
                    break;
                case 3:
                    processAddChips();
                    break;
                case 4:
                    processFinishTheOrder();
                    break;
                default:
                    System.out.println("Invalid choice. Please select from the available options.");
            }
        } while (startCommand != 4);
    }

    private static void processAddASandwich() {
        int sandwichCommand = 0;
        List<Topping> toppingChoices = new ArrayList<>();
        do {
            System.out.println("Choose sandwich size: 4\" ($5.50), 8\" ($7.00), 12\" ($8.50)");
            int size = inputScanner.nextInt();
            inputScanner.nextLine();

            Sandwich.Size sandwichSize = null;
            if (size == 4) {
                sandwichSize = Sandwich.Size.SMALL;
            } else if (size == 8) {
                sandwichSize = Sandwich.Size.MEDIUM;
            } else if (size == 12) {
                sandwichSize = Sandwich.Size.LARGE;
            }

            if (sandwichSize == null) {
                System.out.println("Invalid size. Please select 4, 8, or 12 inches.");
                continue;
            }

            System.out.println("Choose bread type: White, Wheat, Rye, Wrap");
            String breadType = inputScanner.nextLine().toUpperCase();

            System.out.println("Do you want it toasted? 1. Yes 2. No");
            int toastedChoiceInput = inputScanner.nextInt();
            boolean toastedChoice = toastedChoiceInput == 1;
            inputScanner.nextLine();

            System.out.println("\n----------------------------");
            System.out.println("Choose your toppings (separate by commas):");
            System.out.println("----------------------------\n");

            System.out.println("Meats:");
            for (Topping topping : PremiumTopping.getPremiumToppings()) {
                if (topping.getType().equals("Meat")) {
                    System.out.println(topping.getName());
                }
            }

            System.out.println("\n----------------------------");
            System.out.println("Cheeses:");
            for (Topping topping : PremiumTopping.getPremiumToppings()) {
                if (topping.getType().equals("Cheese")) {
                    System.out.println(topping.getName());
                }
            }

            System.out.println("\n----------------------------");
            System.out.println("Veggies:");
            for (Topping topping : RegularTopping.getRegularToppings()) {
                if (topping.getType().equals("Veggie")) {
                    System.out.println(topping.getName());
                }
            }

            System.out.println("\n----------------------------");
            System.out.println("Sauces:");
            for (Topping topping : RegularTopping.getRegularToppings()) {
                if (topping.getType().equals("Sauce")) {
                    System.out.println(topping.getName());
                }
            }

            System.out.println("\n----------------------------");
            System.out.println("Enter your toppings (separate by commas):");
            String inputToppings = inputScanner.nextLine().toLowerCase();

            String[] selectedToppings = inputToppings.split(",");
            for (String toppingName : selectedToppings) {
                toppingName = toppingName.trim();
                Topping topping = findToppingByName(toppingName);
                if (topping != null) {
                    toppingChoices.add(topping);
                    System.out.println(topping.getName() + " added.");
                } else {
                    System.out.println("Invalid topping: " + toppingName);
                }
            }

            System.out.println("\nWould you like extra meat? 1. Yes 2. No");
            boolean extraMeatChoice = inputScanner.nextInt() == 1;
            inputScanner.nextLine();

            System.out.println("Would you like extra cheese? 1. Yes 2. No");
            boolean extraCheeseChoice = inputScanner.nextInt() == 1;
            inputScanner.nextLine();

            Sandwich sandwich = new Sandwich(toppingChoices, extraMeatChoice, extraCheeseChoice, sandwichSize, Sandwich.BreadTypes.valueOf(breadType), toastedChoice);
            sandwiches.add(sandwich);

            totalPrice += sandwich.calculatePrice();
            System.out.println("Sandwich added. Total: $" + totalPrice);

            System.out.println("\n----------------------------");
            System.out.println("Add another sandwich? 1. Yes 2. No");
            sandwichCommand = inputScanner.nextInt();
            inputScanner.nextLine();
        } while (sandwichCommand != 2);
    }

    private static void processAddADrink() {
        int sizeChoice;
        do {
            System.out.println("What's your drink size? 1. Small ($2.00) 2. Medium ($2.50) 3. Large ($3.00) 4. No more drinks");
            sizeChoice = commandScanner.nextInt();
            commandScanner.nextLine();

            if (sizeChoice == 4) {
                break;
            }

            System.out.println("Available drink flavors:");
            String[] availableFlavors = Drink.getAvailableFlavors();
            for (int i = 0; i < availableFlavors.length; i++) {
                System.out.println((i + 1) + ". " + availableFlavors[i]);
            }

            System.out.println("Enter your drink flavor:");
            String drinkFlavor = inputScanner.nextLine().trim().toUpperCase();

            boolean validFlavor = false;
            for (String flavor : availableFlavors) {
                if (flavor.equalsIgnoreCase(drinkFlavor)) {
                    validFlavor = true;
                    break;
                }
            }

            if (!validFlavor) {
                System.out.println("Invalid flavor. Please choose a valid option.");
            } else {
                try {
                    Drink drink = new Drink(drinkFlavor, Drink.Size.values()[sizeChoice - 1]);
                    drinks.add(drink);
                    totalPrice += drink.calculatePrice();
                    System.out.println(drinkFlavor + " added. Price: $" + drink.calculatePrice());
                } catch (IllegalArgumentException e) {
                    System.out.println("Error: Invalid flavor or size.");
                }
            }

        } while (sizeChoice != 4);
    }

    private static void processAddChips() {
        String chipsChoice;
        int chipsCommand;
        int numberOfBags;
        do {
            System.out.println("What chips do you want?");
            for (Chips.Types type : Chips.Types.values()) {
                System.out.println(type);
            }

            chipsChoice = inputScanner.nextLine().trim().toUpperCase();
            Chips.Types selectedType = Chips.Types.valueOf(chipsChoice);

            System.out.println("How many bags of chips do you want?");
            numberOfBags = inputScanner.nextInt();

            Chips chipsBag = new Chips(selectedType, numberOfBags);
            chips.add(chipsBag);
            totalPrice += chipsBag.calculatePrice();
            System.out.println(chipsChoice + " chips added. Total: $" + chipsBag.calculatePrice());

            System.out.println("Add another bag of chips? 1. Yes 2. No");
            chipsCommand = commandScanner.nextInt();
            inputScanner.nextLine();
        } while (chipsCommand == 1);
    }

    private static void processFinishTheOrder() {
        totalPrice = 0.0;
        System.out.println("What's your name?");
        name = inputScanner.nextLine();

        System.out.println("Your order details: ");
        System.out.println("\n----------------------------");
        System.out.println("Your sandwiches: ");
        int sandwichNumber = 1;
        List<Product> allProducts = new ArrayList<>();

        for (Sandwich sandwich : sandwiches) {
            System.out.println("Sandwich " + sandwichNumber + ":");
            System.out.println("Size: " + sandwich.getSize());
            System.out.println("Bread: " + sandwich.getBreadType());
            List<Topping> toppings = sandwich.getToppings();
            if (toppings.isEmpty()) {
                System.out.println("No toppings.");
            } else {
                for (Topping topping : toppings) {
                    System.out.println("- " + topping.getName());
                }
            }
            System.out.println("Toasted: " + (sandwich.isToasted() ? "Yes" : "No"));
            sandwichNumber++;
            allProducts.add(sandwich);
            totalPrice += sandwich.calculatePrice();
        }

        System.out.println("\nYour drinks: ");
        for (Drink drink : drinks) {
            System.out.println(drink.getFlavor() + " (" + drink.getSize() + ") - $" + drink.calculatePrice());
            allProducts.add(drink);
            totalPrice += drink.calculatePrice();
        }

        System.out.println("\nYour chips: ");
        for (Chips chip : chips) {
            System.out.println(chip.getType() + " - $" + chip.calculatePrice());
            allProducts.add(chip);
            totalPrice += chip.calculatePrice();
        }

        System.out.println("\nTotal: $" + totalPrice);

        order = new Order(name, allProducts);

        Receipt receipt = new Receipt(name, LocalDateTime.now(), allProducts, totalPrice);
        FileManager.saveReceipt(receipt);

        System.out.println("Thank you for your order!");
        System.exit(0);
    }

    private static Topping findToppingByName(String name) {
        String normalizedToppingName = name.trim().toLowerCase();

        for (PremiumTopping premiumTopping : PremiumTopping.getPremiumToppings()) {
            if (premiumTopping.getName().toLowerCase().equals(normalizedToppingName)) {
                return premiumTopping;
            }
        }

        for (Topping regularTopping : RegularTopping.getRegularToppings()) {
            if (regularTopping.getName().toLowerCase().equals(normalizedToppingName)) {
                return regularTopping;
            }
        }

        return null;
    }
}