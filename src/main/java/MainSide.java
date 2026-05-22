public class MainSide extends Product{
    private String type;

    public MainSide(String name, Size size) {
        super(name, size);
    }

    @Override
    public double calculatedPrice() {
        return 0;
    }
}
