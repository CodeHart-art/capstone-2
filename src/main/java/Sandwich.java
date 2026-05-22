import java.util.ArrayList;


public class Sandwich extends Product{
    private ArrayList<Topping> meats;
    private ArrayList<Topping> premiumToppings;
    private ArrayList<Topping> otherToppings;
    private ArrayList<String> condiments;
    private boolean extraMeat;

    public Sandwich(String name, Size size, ArrayList<Topping> meats, ArrayList<Topping> premiumToppings, ArrayList<Topping> otherToppings, ArrayList<String> condiments, boolean extraMeat) {
        super(name, size);
        this.meats = meats;
        this.premiumToppings = premiumToppings;
        this.otherToppings = otherToppings;
        this.condiments = condiments;
        this.extraMeat = extraMeat;
    }

    //region GETTERS
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

    public boolean isExtraMeat(){
        return extraMeat;
    }
    //endregion

    public ArrayList<Topping> addTopping(){
        //TODO add to list
    }

    public ArrayList<Topping> removeTopping(){
        //TODO remove from list
    }

    @Override
    public double calculatedPrice() {
        //TODO Calculate price DUHHHHH!
        return 0;
    }


}
