public class Drink extends Product {
    private String flavor;

    public Drink(String name, Size size, String flavor) {
        super(name, size);
        this.flavor = flavor;
    }

    @Override
    public double calculatedPrice() {
        if (size == Size.SMALL) {
            return 2.00;

        } else if (size == Size.Medium) {
            return 2.50;

        }
        return 3.00;

    }
}
