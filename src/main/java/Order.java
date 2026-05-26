import java.util.ArrayList;

public class Order {
    private ArrayList<Product> items;

    public Order() {
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
       items.clear();
    }

    public void getOrderInfo(){
        for (Product p : items){
            if (p instanceof Sandwich || p instanceof Drink){
                p.getSize();
            }
            p.getName();
            p.calculatedPrice();
        }
    }


}
