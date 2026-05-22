public class Drink extends Product{
    private DrinkFlavor flavor;

    public Drink(String name, Size size, DrinkFlavor flavor) {
        super(name, size);
        this.flavor = flavor;
    }

    @Override
    public double calculatedPrice() {
        return 0;
    }
}
