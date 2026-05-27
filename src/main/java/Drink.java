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

        } else if (size == Size.LARGE) {
            return 3.00;
        }
        return 0;
    }

    @Override
    public String toString(){

        return name +" "+size;
    }
}
