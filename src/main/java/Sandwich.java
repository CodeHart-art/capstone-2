import java.util.ArrayList;


public class Sandwich extends Product{
    private ArrayList<Topping> meats;
    private ArrayList<Topping> premiumToppings;
    private ArrayList<Topping> otherToppings;
    private ArrayList<String> condiments;
    private boolean extraMeat;
    private boolean extraCheese;

    public Sandwich(String name, Size size, ArrayList<Topping> meats, ArrayList<Topping> premiumToppings, ArrayList<Topping> otherToppings, ArrayList<String> condiments, boolean extraMeat,boolean extraCheese) {
        super(name, size);
        this.meats = new ArrayList<>();
        this.premiumToppings = new ArrayList<>();
        this.otherToppings = new ArrayList<>();
        this.condiments = new ArrayList<>();
        this.extraMeat = false;
        this.extraCheese = false;
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

    public void addTopping(Topping topping){
        meats.add(topping);
        premiumToppings.add(topping);
        otherToppings.add(topping);
    }

    public void removeTopping(Topping topping){
        meats.remove(topping);
        premiumToppings.remove(topping);
        otherToppings.remove(topping);
    }

    public void addCondiment(String condiment){
        condiments.add(condiment);
    }

    public void removeCondiment(String condiment){
        condiments.remove(condiment);
    }

    @Override
    public double calculatedPrice(){
        //TODO Calculate price DUHHHHH!
        return 0;
    }


}
