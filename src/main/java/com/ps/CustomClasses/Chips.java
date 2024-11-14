package com.ps.CustomClasses;

public class Chips extends Product {

    private String type;

    public enum Types {
        JALAPENO, BBQ, LAYS
    }

    public Chips(String type) {
        super(type, 1.50);
        this.type = type;
    }

    public Chips(Chips.Types selectedType, int numberOfBags) {
        super(selectedType.name(), 1.50 * numberOfBags);
        this.type = selectedType.name();
    }

    @Override
    public double calculatePrice() {
        return 1.50;
    }

    public String getType() {
        return type;
    }

    public Chips.Types getChipsType() {
        return Chips.Types.valueOf(type);
    }

    @Override
    public String getName() {
        return "Chips: " + type;
    }
}
