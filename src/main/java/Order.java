import java.util.ArrayList;

public class Order {
    private ArrayList<Product> items;

    public Order() {
        this.items = new ArrayList<>();
    }

    public void addProduct(Product product) {
        items.add(product);
    }

    public void removeProduct(Product product) {
        items.remove(product);
    }

    public double calculateTotal() {
        double total = 0;
        for (Product p : items) {
            total += p.calculatedPrice();
        }
        return total;
    }

    public String getOrderInfo() {
        String fullOrder = """
                Here's your Order:
                --------------------------------------
                """;

        for (Product p : items) {
            String size;
            if (p.getSize() == null) {
                size = "";
            } else {
                size = p.getSize().toString();
            }

            fullOrder += String.format(
                    "%-20s %-10s $%.2f%n",
                    p.getName(),
                    size,
                    p.calculatedPrice()
            );
        }

        fullOrder += "--------------------------------------\n";
        fullOrder += String.format("%-20s %-10s $%.2f%n", "", "TOTAL", calculateTotal());

        return fullOrder;
    }

    public boolean isValidOrder() {

        boolean hasSandwich = false;
        boolean hasSide = false;

        for (Product p : items) {

            if (p instanceof Sandwich) {
                hasSandwich = true;
            }

            if (p instanceof MainSide) {
                hasSide = true;
            }
        }

        return hasSandwich || hasSide;
    }

    public void clearOrder() {
        items.clear();
    }

}
