public abstract class Product {

    protected String name;
    protected Size size;

    public Product(String name, Size size) {
        this.name = name;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public Size getSize() {
        return size;
    }

    public abstract double calculatedPrice();

}
