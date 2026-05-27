import java.util.Scanner;

public class UI {
    static Scanner userInput = new Scanner(System.in);
    static String INPUT;

    public static void homeScreen() {
        while (true) {
            System.out.println("Welcome to the shop please enter an option");
            System.out.println("""
                    1) NEW ORDER
                    0) EXIT
                    """);
            INPUT = userInput.nextLine();

            switch (INPUT) {
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
            INPUT = userInput.nextLine();

            switch (INPUT) {
                case "1":
                    addSandwich();
                    break;
                case "2":
                    addDrink();
                    break;
                case "3":
                    addChips();
                    break;
                case "4":
                    checkout();
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

    private static void checkout() {
    }

    private static void addChips() {
    }

    private static void addDrink() {
    }

    private static void addSandwich() {
    }


}
