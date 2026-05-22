public class Topping {
    private String name;
    private ToppingType type;

    public Topping(String name, ToppingType type) {
        this.name = name;
        this.type = type;
    }

    //region GETTERS
    public String getName() {
        return name;
    }

    public ToppingType getType() {
        return type;
    }

    //endregion


}
