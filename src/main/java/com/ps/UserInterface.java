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

    private static final String RESET = "\033[0m";
    private static final String BOLD = "\033[1m";
    private static final String BLUE = "\033[34m";
    private static final String GREEN = "\033[32m";
    private static final String CYAN = "\033[36m";
    private static final String RED = "\033[31m";
    private static final String YELLOW = "\033[33m";


    public static void display() {
        showMainMenu();
    }

    public static void showMainMenu() {
        int mainMenuCommand;
        do {
            clearScreen();
            System.out.println(CYAN + "==============================================");
            System.out.println("          🥪    Welcome to Deli-cious!   🥪  ");
            System.out.println("==============================================");
            System.out.println(RESET);
            System.out.println(YELLOW + "       👨‍🍳  Would you like to place an order?  👩‍🍳");
            System.out.println("                 1. Yes");
            System.out.println("                 2. No");
            mainMenuCommand = commandScanner.nextInt();
            switch (mainMenuCommand) {
                case 1:
                    processStartAnOrder();
                    break;
                case 2:
                    System.out.println(GREEN + "Exiting...Goodbye!" + RESET);
                    break;
                default:
                    System.out.println(BLUE + "Invalid choice. Please enter 1 or 2." + RESET);
            }
        } while (mainMenuCommand != 2);
    }

    private static void processStartAnOrder() {
        int startCommand = 0;
        do {
            clearScreen();
            System.out.println(CYAN + "\n=============================================");
            System.out.println("        🍽️  What would you like to order? 🍽️");
            System.out.println("=============================================" + RESET);
            System.out.println(YELLOW + "    1. 🥪 Add a Sandwich");
            System.out.println("    2. 🥤 Add a Drink");
            System.out.println("    3. 🍟 Add Chips");
            System.out.println("    4. ✅ Finish the Order");
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
                    System.out.println(BLUE + "Invalid choice. Please select from the available options." + RESET);
            }
        } while (startCommand != 4);
    }

    private static void processAddASandwich() {
        int sandwichCommand = 0;

        do {
            clearScreen();
            System.out.println(CYAN + "\n=============================================");
            System.out.println("  🤔 How hungry are you today? Choose a size! 🍽️");
            System.out.println("=============================================" + RESET);
            System.out.println(YELLOW + "    1. 🌱 Small - 4\" ($5.50)");
            System.out.println("    2. 🥪 Medium - 8\" ($7.00)");
            System.out.println("    3. 🍔 Large - 12\" ($8.50)");
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
                System.out.println(BLUE + "Invalid size. Please select 4, 8, or 12 inches." + RESET);
                continue;
            }

            List<Topping> toppingChoices = new ArrayList<>();

            clearScreen();
            System.out.println(CYAN + "\n=============================================");
            System.out.println("   🌾 What kind of bread would you like today? 🍞");
            System.out.println("=============================================" + RESET);
            System.out.println(YELLOW + "    1. 🍞 White - Classic choice!");
            System.out.println("    2. 🌾 Wheat - A healthy option!");
            System.out.println("    3. 🌿 Rye - For the adventurous eater!");
            System.out.println("    4. 🌯 Wrap - For something light and fresh!");
            String breadType = inputScanner.nextLine().toUpperCase();
            clearScreen();
            System.out.println(CYAN + "\n===============================================");
            System.out.println("   🔥 Would you like your sandwich toasted? 🥪");
            System.out.println("===============================================" + RESET);
            System.out.println(YELLOW + "    1. Yes, make it crispy! 🔥");
            System.out.println("    2. No, keep it soft and fresh! 🍞");
            int toastedChoiceInput = inputScanner.nextInt();
            boolean toastedChoice = toastedChoiceInput == 1;
            inputScanner.nextLine();
            clearScreen();
            System.out.println("\n===========================================");
            System.out.println(CYAN + "🥗 What toppings would you like to add? 🧀");
            System.out.println("===========================================" + RESET);
            System.out.println(YELLOW + "    Pick your favorites, separate by commas! 🍅🥬🍔");
            System.out.println("===========================================\n");

            System.out.println(CYAN + "Meats:" + RESET);
            for (Topping topping : PremiumTopping.getPremiumToppings()) {
                if (topping.getType().equals("Meat")) {
                    System.out.println(topping.getName());
                }
            }

            System.out.println("\n----------------------------");
            System.out.println(CYAN + "Cheeses:" + RESET);
            for (Topping topping : PremiumTopping.getPremiumToppings()) {
                if (topping.getType().equals("Cheese")) {
                    System.out.println(topping.getName());
                }
            }

            System.out.println("\n----------------------------");
            System.out.println(CYAN + "Veggies:" + RESET);
            for (Topping topping : RegularTopping.getRegularToppings()) {
                if (topping.getType().equals("Veggie")) {
                    System.out.println(topping.getName());
                }
            }

            System.out.println("\n----------------------------");
            System.out.println(CYAN + "Sauces:" + RESET);
            for (Topping topping : RegularTopping.getRegularToppings()) {
                if (topping.getType().equals("Sauce")) {
                    System.out.println(topping.getName());
                }
            }

            System.out.println("\n=====================================");
            System.out.println(CYAN + "🥒 Ready to customize your sandwich? 🌶️");
            System.out.println("=====================================" + RESET);
            System.out.println(YELLOW + "    Enter your topping choices below (separate by commas)!");
            System.out.println("=====================================\n");
            String inputToppings = inputScanner.nextLine().toLowerCase();

            String[] selectedToppings = inputToppings.split(",");
            for (String toppingName : selectedToppings) {
                toppingName = toppingName.trim();
                Topping topping = findToppingByName(toppingName);
                if (topping != null) {
                    toppingChoices.add(topping);
                    System.out.println(topping.getName() + " added.");
                } else {
                    System.out.println(BLUE + "Invalid topping: " + toppingName + RESET);
                }
            }
            clearScreen();
            System.out.println("\n=====================================");
            System.out.println(CYAN + "🍖 Craving extra meat today? 🥩");
            System.out.println("=====================================" + RESET);
            System.out.println(YELLOW + "1. Yes, give me more meat!");
            System.out.println("2. No, I'm good with what I have.");
            System.out.println("=====================================");
            boolean extraMeatChoice = inputScanner.nextInt() == 1;
            inputScanner.nextLine();
            clearScreen();
            System.out.println("\n=====================================");
            System.out.println(CYAN + "🧀 Time for some extra cheese? 🧀");
            System.out.println("=====================================" + RESET);
            System.out.println(YELLOW + "1. Yes, more cheese, please!");
            System.out.println("2. No, I’m keeping it cheesy enough.");
            System.out.println("=====================================");
            boolean extraCheeseChoice = inputScanner.nextInt() == 1;
            inputScanner.nextLine();

            Sandwich sandwich = new Sandwich(toppingChoices, extraMeatChoice, extraCheeseChoice, sandwichSize, Sandwich.BreadTypes.valueOf(breadType), toastedChoice);
            sandwiches.add(sandwich);
clearScreen();
            totalPrice += sandwich.calculatePrice();
            System.out.println(GREEN + "🍞 Your delicious sandwich has been added! 🥪");
            System.out.println("Total after this one: $" + totalPrice + RESET);
            System.out.println("\n----------------------------");
            System.out.println(GREEN + "🍽️ Hungry for more? Add another tasty sandwich!" + RESET);
            System.out.println("1. Yes, please! 😋");
            System.out.println("2. No, I'm full! 😌");
            sandwichCommand = inputScanner.nextInt();
            inputScanner.nextLine();
        } while (sandwichCommand != 2);
    }

    private static void processAddADrink() {
        int sizeChoice;
        do {
            clearScreen();
            System.out.println(CYAN + "🥤 Quenching your thirst? Choose your drink size!" + RESET);
            System.out.println("1. Small ($2.00) – Just a sip 🍹");
            System.out.println("2. Medium ($2.50) – A refreshing gulp 🥤");
            System.out.println("3. Large ($3.00) – Drink up! 🏆");
            System.out.println("4. No more drinks – I'm good, thanks! 🙌");
            sizeChoice = commandScanner.nextInt();
            commandScanner.nextLine();

            if (sizeChoice == 4) {
                break;
            }
            clearScreen();
            System.out.println(CYAN + "🍹 Time to choose your flavor! What are you in the mood for?" + RESET);
            String[] availableFlavors = Drink.getAvailableFlavors();
            for (int i = 0; i < availableFlavors.length; i++) {
                System.out.println((i + 1) + ". " + availableFlavors[i]);
            }

            System.out.println(CYAN + "🌟 What's your drink flavor today? (Choose wisely! 😉)" + RESET);
            String drinkFlavor = inputScanner.nextLine().trim().toUpperCase();

            boolean validFlavor = false;
            for (String flavor : availableFlavors) {
                if (flavor.equalsIgnoreCase(drinkFlavor)) {
                    validFlavor = true;
                    break;
                }
            }

            if (!validFlavor) {
                System.out.println(RED + "Invalid flavor. Please choose a valid option." + RESET);
            } else {
                try {
                    Drink drink = new Drink(drinkFlavor, Drink.Size.values()[sizeChoice - 1]);
                    drinks.add(drink);
                    totalPrice += drink.calculatePrice();
                    System.out.println(CYAN + "🥤 " + drinkFlavor + " has been added to your order! Price: $" + drink.calculatePrice() + RESET);
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
            clearScreen();
            System.out.println(CYAN + "🍟 What kind of chips would you like to enjoy today?" + RESET);
            for (Chips.Types type : Chips.Types.values()) {
                System.out.println(type);
            }

            chipsChoice = inputScanner.nextLine().trim().toUpperCase();
            Chips.Types selectedType = Chips.Types.valueOf(chipsChoice);

            System.out.println(CYAN + "🥔 How many bags of crispy chips would you like to grab?" + RESET);
            numberOfBags = inputScanner.nextInt();

            Chips chipsBag = new Chips(selectedType, numberOfBags);
            chips.add(chipsBag);

            double chipsTotal = chipsBag.calculatePrice() * numberOfBags;
            totalPrice += chipsTotal;

            System.out.println(CYAN + "Yay! " + chipsChoice + " chips added to your order. Crunchy goodness! Total for " + numberOfBags + " bags: $" + chipsTotal + RESET);

            System.out.println(CYAN + "Would you like to add another bag of " + chipsChoice + " chips to your order? 1. Yes, please! 2. No, I'm good!" + RESET);
            chipsCommand = commandScanner.nextInt();
            inputScanner.nextLine();
        } while (chipsCommand == 1);
    }

    private static void processFinishTheOrder() {
        totalPrice = 0.0;
        System.out.println(CYAN + "😊 What’s a good name for the order? We'd love to know!" + RESET);
        name = inputScanner.nextLine();
        clearScreen();
        System.out.println(GREEN + "🌟 Your order details: 🌟" + RESET);
        System.out.println("\n----------------------------");
        System.out.println(GREEN + "🍔 Your delicious sandwiches: 🍔" + RESET);
        int sandwichNumber = 1;
        List<Product> allProducts = new ArrayList<>();

        for (Sandwich sandwich : sandwiches) {
            System.out.println(CYAN + "🥪 Sandwich " + sandwichNumber + ":" + RESET);
            System.out.println("  📏 Size: " + sandwich.getSize());
            System.out.println("  🍞 Bread: " + sandwich.getBreadType());
            List<Topping> toppings = sandwich.getToppings();
            if (toppings.isEmpty()) {
                System.out.println("  🌱 No toppings (Simple and fresh!)");
            } else {
                System.out.println("  🌿 Toppings:");
                for (Topping topping : toppings) {
                    System.out.println("    - " + topping.getName());
                }
            }
            System.out.println("  🔥 Toasted? " + (sandwich.isToasted() ? "Yes, crispy and warm!" : "No, cool and fresh."));
            sandwichNumber++;
            allProducts.add(sandwich);
            totalPrice += sandwich.calculatePrice();
        }

        System.out.println(GREEN + "\n🥤 Your refreshing drinks: 🥤" + RESET);
        for (Drink drink : drinks) {
            System.out.println("  🍹 " + drink.getFlavor() + " (" + drink.getSize() + ") - $" + drink.calculatePrice());
            allProducts.add(drink);
            totalPrice += drink.calculatePrice();
        }

        System.out.println(GREEN + "\n🍟 Your crispy chips: 🍟" + RESET);
        for (Chips chip : chips) {
            System.out.println("  🍽 " + chip.getType() + " - $" + chip.calculatePrice());
            allProducts.add(chip);
            totalPrice += chip.calculatePrice();
        }

        System.out.println("\n🎉 Total: $" + totalPrice + " 🎉");

        order = new Order(name, allProducts);

        Receipt receipt = new Receipt(name, LocalDateTime.now(), allProducts, totalPrice);
        FileManager.saveReceipt(receipt);

        System.out.println(GREEN + "🎉 Thank you for your order! 🎉" + RESET);
        System.out.println(CYAN + "We hope you enjoy your meal! 🍽️ Come back soon for more deli-ciousness! 😋" + RESET);

        System.out.println(CYAN + "Would you like to place another order? (1. Yes, 2. No)" + RESET);
        int choice = inputScanner.nextInt();
        inputScanner.nextLine();

        if (choice == 1) {
            sandwiches.clear();
            drinks.clear();
            chips.clear();
            totalPrice = 0.0;
            showMainMenu();
        } else {
            System.out.println(GREEN + "Thank you for visiting! Goodbye! 👋" + RESET);
            System.exit(0);
        }
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

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
