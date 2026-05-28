import java.util.ArrayList;


public class Sandwich extends Product {
    private BreadType breadType;
    private ArrayList<Topping> meats;
    private ArrayList<Topping> premiumToppings;
    private ArrayList<Topping> otherToppings;
    private ArrayList<String> condiments;
    private boolean extraMeat;
    private boolean extraCheese;
    private boolean isToasted;

    public Sandwich(String name, Size size, BreadType breadType) {
        super(name, size);
        this.breadType = breadType;

        this.meats = new ArrayList<>();
        this.premiumToppings = new ArrayList<>();
        this.otherToppings = new ArrayList<>();
        this.condiments = new ArrayList<>();
        this.extraMeat = false;
        this.extraCheese = false;
        this.isToasted = false;
    }

    //region GETTERS and SETTERS

    public void setToasted(boolean toasted) {
        isToasted = toasted;
    }

    public BreadType getBreadType() {
        return breadType;
    }

    public ArrayList<Topping> getMeats() {
        return meats;
    }

    public ArrayList<Topping> getPremiumToppings() {
        return premiumToppings;
    }

    public ArrayList<Topping> getOtherToppings() {
        return otherToppings;
    }

    public ArrayList<String> getCondiments() {
        return condiments;
    }

    public boolean isExtraMeat() {
        return extraMeat;
    }

    public boolean hasExtraCheese() {
        return extraCheese;
    }

    public void setExtraCheese(boolean extraCheese) {
        this.extraCheese = extraCheese;
    }

    public void setExtraMeat(boolean extraMeat) {
        this.extraMeat = extraMeat;
    }
    //endregion and SETTERS and

    public void addTopping(Topping topping) {
        if (topping.getType() == ToppingType.MEAT) {
            meats.add(topping);
        } else if (topping.getType() == ToppingType.PREMIUM) {
            premiumToppings.add(topping);
        } else if (topping.getType() == ToppingType.OTHER) {
            otherToppings.add(topping);
        }
    }

    public void addCondiment(String condiment) {
        condiments.add(condiment);
    }

    @Override
    public String toString(){
        String sandwichInfo = "";

        sandwichInfo += "========== SANDWICH ==========\n";

        sandwichInfo += size + " " + breadType + " Sandwich\n";

        sandwichInfo += "Toasted: " + isToasted + "\n";

        sandwichInfo += "\nMeats:\n";

        for (Topping t : meats) {
            sandwichInfo += "- " + t.getName() + "\n";
        }

        if (meats.isEmpty()) {
            sandwichInfo += "- None\n";
        }

        sandwichInfo += "\nPremium Toppings:\n";

        for (Topping t : premiumToppings) {
            sandwichInfo += "- " + t.getName() + "\n";
        }

        if (premiumToppings.isEmpty()) {
            sandwichInfo += "- None\n";
        }

        sandwichInfo += "\nRegular Toppings:\n";

        for (Topping t : otherToppings) {
            sandwichInfo += "- " + t.getName() + "\n";
        }

        if (otherToppings.isEmpty()) {
            sandwichInfo += "- None\n";
        }

        sandwichInfo += "\nSauces:\n";

        for (String condiment : condiments) {
            sandwichInfo += "- " + condiment + "\n";
        }

        if (condiments.isEmpty()) {
            sandwichInfo += "- None\n";
        }

        sandwichInfo += "\nExtra Meat: " + extraMeat + "\n";
        sandwichInfo += "Extra Cheese: " + extraCheese + "\n";

        sandwichInfo += String.format("\nPrice: $%.2f%n", calculatedPrice());

        sandwichInfo += "==============================";

        return sandwichInfo;
    }

    @Override
    public double calculatedPrice() {
        double baseCost = 0;

        if (size == Size.SMALL) {
            baseCost = 5.50;
            if (!meats.isEmpty())
                baseCost += 1.00;
            if (!premiumToppings.isEmpty())
                baseCost += .75;
            if (extraMeat)
                baseCost += .50;
            if (extraCheese)
                baseCost += .30;

            return baseCost;
        } else if (size == Size.MEDIUM) {
            baseCost = 7.00;
            if (!meats.isEmpty())
                baseCost += 2.00;
            if (!premiumToppings.isEmpty())
                baseCost += 1.50;
            if (extraMeat)
                baseCost += 1;
            if (extraCheese)
                baseCost += .60;

            return baseCost;
        } else if (size == Size.LARGE) {
            baseCost = 8.50;
            if (!meats.isEmpty())
                baseCost += 3.00;
            if (!premiumToppings.isEmpty())
                baseCost += 2.25;
            if (extraMeat)
                baseCost += 1.50;
            if (extraCheese)
                baseCost += .90;

            return baseCost;
        }
        return baseCost;

    }


}
