public class Topping {
    private String name;
    private double price;
    private ToppingType type;

    public Topping(String name, double price, ToppingType type) {
        this.name = name;
        this.price = price;
        this.type = type;
    }

    //region GETTERS
    public String getName() {
        return name;
    }

    public double getPrice() {
        if (type == ToppingType.MEAT){
            price =
        }

    }

    public ToppingType getType() {
        return type;
    }

    //endregion


}
