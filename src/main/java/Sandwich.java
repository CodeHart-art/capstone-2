import java.util.ArrayList;


public class Sandwich extends Product {
    private BreadType breadType;
    private ArrayList<Topping> meats;
    private ArrayList<Topping> premiumToppings;
    private ArrayList<Topping> otherToppings;
    private ArrayList<String> condiments;
    private boolean extraMeat;
    private boolean extraCheese;

    public Sandwich(String name, Size size, ArrayList<Topping> meats, ArrayList<Topping> premiumToppings, ArrayList<Topping> otherToppings, ArrayList<String> condiments, boolean extraMeat, boolean extraCheese, BreadType breadType) {
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

    @Override
    public double calculatedPrice() {
        double baseCost = 0;

        if (size == Size.SMALL) {
           baseCost = 3.50;
            if (!meats.isEmpty())

            return 0;
        }
        else if (size == Size.Medium) {
            baseCost = 8.50;


            return 0;
        }
        else if (size == Size.LARGE) {
            baseCost = 9.00;


            return 0;
        }
        return 0;

    }


}
