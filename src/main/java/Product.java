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


    /**
     * ALLOW EACH PRODUCT TO CALCULATE ITS OWN PRICE TO GET ORDER TOTAL IN THE FUTURE
     * @return
     */
    public abstract double calculatedPrice();

}
