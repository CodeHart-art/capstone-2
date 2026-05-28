import java.util.ArrayList;


public class Sandwich extends Product {
    private BreadType breadType;
    private ArrayList<Topping> meats;
    private ArrayList<Topping> premiumToppings;
    private ArrayList<Topping> otherToppings;
    private ArrayList<String> condiments;
    private boolean extraMeat;
    private boolean extraCheese;

    public Sandwich(String name, Size size, BreadType breadType) {
        super(name, size);
        this.breadType = breadType;

        this.meats = new ArrayList<>();
        this.premiumToppings = new ArrayList<>();
        this.otherToppings = new ArrayList<>();
        this.condiments = new ArrayList<>();
        this.extraMeat = false;
        this.extraCheese = false;
    }

    //region GETTERS and SETTERS

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

    public void setExtraCheese() {
        extraCheese = true;
    }

    public void setExtraMeat() {
        extraCheese = true;
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

    public void removeTopping(Topping topping) {
        if (topping.getType() == ToppingType.MEAT) {
            meats.remove(topping);
        } else if (topping.getType() == ToppingType.PREMIUM) {
            premiumToppings.remove(topping);
        } else if (topping.getType() == ToppingType.OTHER) {
            otherToppings.remove(topping);
        }
    }

    public void addCondiment(String condiment) {
        condiments.add(condiment);
    }

    public void removeCondiment(String condiment) {
        condiments.remove(condiment);
    }

    // TODO make more efficient check size  then do calculation
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
