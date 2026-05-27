import java.util.Scanner;

public class UI {
    static Scanner userInput = new Scanner(System.in);


    public static void homeScreen() {
        while (true) {
            System.out.println("Welcome to the shop please enter an option");
            System.out.println("""
                    1) NEW ORDER
                    0) EXIT
                    """);
            String input = userInput.nextLine();

            switch (input) {
                case "1":
                    orderScreen();
                    break;
                case "0":
                    System.out.println("EXITING PROGRAM...");
                    System.exit(0);
                default:
                    System.out.println("Select from available options");
            }
        }


    }

    public static void orderScreen() {
        Order currentOrder = new Order();
        boolean active = true;

        while (active) {
            System.out.println("Select your order");
            System.out.println("""
                    1) Add Sandwich
                    2) Add Drink
                    3) Add chips
                    4) Checkout
                    0) Cancel Order
                    """);
            String input = userInput.nextLine();

            switch (input) {
                case "1":
                    addSandwich(currentOrder);
                    break;
                case "2":
                    addDrink(currentOrder);
                    break;
                case "3":
                    addChips(currentOrder);
                    break;
                case "4":
                    checkout(currentOrder);
                    break;
                case "0":
                    active = false;
                    System.out.println("Clearing order returning to main menu");
                    break;
                default:
                    System.out.println("SELECT FROM AVAILABLE OPTIONS");
                    break;
            }
        }
    }

    private static void checkout(Order currentOrder) {
    }

    private static void addChips(Order currentOrder) {
    }

    private static void addDrink(Order currentOrder) {
    }

    private static void addSandwich(Order currentOrder) {
        BreadType breadType = null;
        Size size = null;
        ToppingName tName = null;

        System.out.println("Select your bread");
        System.out.println("""
                1) White bread
                2) Wheat bread
                3) Rye bread
                4) Wrap
                """);
        String input = userInput.nextLine();

        switch (input) {
            case "1":
                breadType = BreadType.WHITE;
                break;
            case "2":
                breadType = BreadType.WHEAT;
                break;
            case "3":
                breadType = BreadType.RYE;
                break;
            case "4":
                breadType =BreadType.WRAP;
                break;
            default:
                System.out.println("Please select from provided option");

        }

        System.out.println("Select Sandwich Size");
        System.out.println("""
                1) Small
                2) Medium
                3) Large
                """);
        input = userInput.nextLine();

        switch (input){
            case "1":
                size = Size.SMALL;
                break;
            case "2" :
                size = Size.MEDIUM;
                break;
            case "3":
                size = Size.LARGE;
                break;
            default:
                System.out.println("Please select from provided options");
        }

        Sandwich sandwich = new Sandwich("Sandwich",size,breadType);

        System.out.println("Select Meat options");
        System.out.println("""
                1) Steak
                2) Ham
                3) Salami
                4) Roast Beef
                5) Chicken
                6) Bacon
                """);

        input = userInput.nextLine();

        switch (input){

        }



    }


}
