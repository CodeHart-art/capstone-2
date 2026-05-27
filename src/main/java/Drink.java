public class Drink extends Product {


    public Drink(String name, Size size) {
        super(name, size);

    }

    @Override
    public double calculatedPrice() {
        if (size == Size.SMALL) {
            return 2.00;

        } else if (size == Size.MEDIUM) {
            return 2.50;

        }
        return 3.00;

    }
}
