import java.util.ArrayList;

public class Order {
    private ArrayList<Product> items;

    public Order(ArrayList<Product> items) {
        this.items = new ArrayList<>();
    }

    public void addProduct(Product product){
        items.add(product);
    }

    public void removeProduct(Product product){
        items.remove(product);
    }

    public double calculateTotal(){
        double total = 0;
        for (Product p : items){
            total += p.calculatedPrice();
        }
        return total;
    }

    public void clearOrder(){
        for (Product p : items){
            items.remove(p);
        }
    }


}
