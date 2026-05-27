public class Main {
    public static void main(String[] args) {


        Topping bacon = new Topping("Bacon", ToppingType.MEAT);
        Topping singles = new Topping("Singles", ToppingType.PREMIUM);
        Topping lettuce = new Topping("Lettuce", ToppingType.OTHER);


        Sandwich order1 = new Sandwich("Sandwich", Size.LARGE,BreadType.WHITE);

        order1.addTopping(bacon);
        order1.addTopping(singles);
        order1.addTopping(lettuce);
        order1.setExtraCheese();
        order1.setExtraMeat();

        MainSide fries = new MainSide("Fries");
        Drink pepsi = new Drink("Pepsi",Size.LARGE);

        Order fullOrder = new Order();

       UI.homeScreen();



    }
}
