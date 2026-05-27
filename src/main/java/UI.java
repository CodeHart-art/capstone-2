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
                    System.out.println("Select available options");
            }
        }


    }

    public static void orderScreen() {
        System.out.println("Select");

    }


}
