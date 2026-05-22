public class Drink extends Product{
    private String flavor;

    public Drink(String name, Size size, String flavor) {
        super(name, size);
        this.flavor = flavor;
    }

    @Override
    public double calculatedPrice() {
        return 0;
    }
}
