public class Topping {
    private ToppingName name;
    private ToppingType type;

    public Topping(ToppingName name, ToppingType type) {
        this.name = name;
        this.type = type;
    }

    //region GETTERS
    public ToppingName getName() {
        return name;
    }

    public ToppingType getType() {
        return type;
    }

    //endregion


}
