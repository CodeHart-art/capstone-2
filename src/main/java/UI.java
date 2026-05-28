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
                    addMainSide(currentOrder);
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

        if (!currentOrder.isValidOrder()) {
            System.out.println("Order must contain a sandwich or side");
            return;
        }


        System.out.println("Here's your full order");
        System.out.println(currentOrder.getOrderInfo());

        System.out.println("""
                Confirm Your Order
                1) Yes
                2) No
                """);
        String input = userInput.nextLine();

        switch (input) {
            case "1":
                System.out.println("Thank you for you purchase");
                System.out.println("Generating receipt...");

                ReceiptManager.writeReceipt(currentOrder);
                currentOrder.clearOrder();

                return;
            case "2":
                return;
            default:
                System.out.println("SELECT VALID OPTION");
        }

    }

    private static void addMainSide(Order currentOrder) {
        String name = "";

        boolean activeSideMenu = true;
        while (activeSideMenu) {
            System.out.println("""
                    Select a Side
                    1) Fries
                    2) Mozzarella Sticks
                    3) Popcorn Chicken
                    4) Tomato Soup
                    0) Return to Order Screen
                    """);
            String input = userInput.nextLine();
            switch (input) {
                case "1":
                    name = "Fries";
                    activeSideMenu = false;
                    break;
                case "2":
                    name = "Mozzarella Sticks";
                    activeSideMenu = false;
                    break;
                case "3":
                    name = "Popcorn Chicken";
                    activeSideMenu = false;
                    break;
                case "4":
                    name = "Tomato Soup";
                    activeSideMenu = false;
                    break;
                case "0":
                    return;
                default:
                    System.out.println("Please select from provided options");
            }
        }

        MainSide currentSide = new MainSide(name);

        System.out.println("Add this side");
        System.out.println("""
                1) Yes
                2) No
                """);
        String input = userInput.nextLine();

        switch (input) {
            case "1":
                currentOrder.addProduct(currentSide);
                break;
            case "2":
                break;
            default:
                System.out.println("Select provided options");
        }
    }

    private static void addDrink(Order currentOrder) {
        String name = null;
        Size size = null;

        System.out.println("Select Drink Size");
        System.out.println("""
                1)Small
                2)Medium
                3)Large
                """);
        String input = userInput.nextLine();

        switch (input) {
            case "1":
                size = Size.SMALL;
                break;
            case "2":
                size = Size.MEDIUM;
                break;
            case "3":
                size = Size.LARGE;
                break;
            default:
                System.out.println("Please select from provided options");
        }

        System.out.println("Select Flavor");
        System.out.println("""
                1) Pepsi
                2) Sprite
                3) Coca-Cola
                4) Dr Pepper
                """);

        input = userInput.nextLine();

        switch (input) {
            case "1":
                name = "Pepsi";
                break;
            case "2":
                name = "Sprite";
                break;
            case "3":
                name = "Coca-Cola";
                break;
            case "4":
                name = "Dr Pepper";
            default:
                System.out.println("Please select from provided options");
        }

        Drink currentDrink = new Drink(name, size);

        System.out.println("Here's your drink");

        System.out.println(currentDrink);

        System.out.println("""
                Add Drink to your order
                1) Yes
                2) No
                """);

        input = userInput.nextLine();

        switch (input) {
            case "1":
                currentOrder.addProduct(currentDrink);
                break;
            case "2":
                break;
            default:
                System.out.println("Select provided options");
        }

    }

    private static void addSandwich(Order currentOrder) {
        BreadType breadType = null;
        Size size = null;


        breadType = getBreadType(breadType);
        size = getSize(size);

        Sandwich sandwich = new Sandwich("Sandwich", size, breadType);

        selectMeat(sandwich);
        selectPremiumTopping(sandwich);
        selectOtherTopping(sandwich);
        selectCondiments(sandwich);

        previewSandwich(sandwich);

        confirmOrder(currentOrder, sandwich);
    }

    private static void confirmOrder(Order currentOrder, Sandwich sandwich) {
        boolean confirmSandwichActive = true;
        while (confirmSandwichActive) {
            System.out.println("""
                    Would you like to keep this sandwich
                    1) Yes
                    2) No
                    """);

            String input = userInput.nextLine();

            switch (input) {
                case "1":
                    currentOrder.addProduct(sandwich);
                    confirmSandwichActive = false;
                    break;
                case "2":
                    confirmSandwichActive = false;
                    break;
                default:
                    System.out.println("Select provided options");
            }
        }
    }

    private static void previewSandwich(Sandwich sandwich) {
        System.out.println("Here's your sandwich");
        System.out.println("----------");

        System.out.println(sandwich.getBreadType());
        System.out.println(sandwich.getSize());
        for (String condiment : sandwich.getCondiments()) {
            System.out.println(condiment);
        }

        for (Topping t : sandwich.getMeats()) {
            System.out.println(t.getName());
        }

        for (Topping t : sandwich.getPremiumToppings()) {
            System.out.println(t.getName());
        }

        for (Topping t : sandwich.getOtherToppings()) {
            System.out.println(t.getName());
        }
    }

    private static void selectCondiments(Sandwich sandwich) {
        boolean condimentSelectionActive = false;
        while (!condimentSelectionActive) {
            System.out.println("Select a sauce");
            System.out.println("""
                    1) Mayo
                    2) Ketchup
                    3) All Sauces
                    """);
            String input = userInput.nextLine();

            switch (input) {
                case "1":
                    sandwich.addCondiment("Mayo");
                    condimentSelectionActive = true;
                    break;
                case "2":
                    sandwich.addCondiment("Ketchup");
                    condimentSelectionActive = true;
                    break;
                case "3":
                    sandwich.addCondiment("MayoChup");
                    condimentSelectionActive = true;
                    break;
                default:
                    System.out.println("Select provided options");


            }
        }
    }

    private static void selectOtherTopping(Sandwich sandwich) {
        boolean toppingSelectionActive = true;
        while (toppingSelectionActive) {
            System.out.println("Select Extra Toppings");
            System.out.println("""
                    1) Lettuce      2) Peppers
                    3) Onions       4) Tomatoes
                    5) Jalapenos    6) Cucumbers
                    7) Pickles      8) Guacamole
                    9) Mushrooms    0) Next Menu
                    """);

            String input = userInput.nextLine();

            switch (input) {
                case "1":
                    sandwich.addTopping(ToppingObjects.lettuce());
                    break;
                case "2":
                    sandwich.addTopping(ToppingObjects.peppers());
                    break;
                case "3":
                    sandwich.addTopping(ToppingObjects.onions());
                    break;
                case "4":
                    sandwich.addTopping(ToppingObjects.tomatoes());
                    break;
                case "5":
                    sandwich.addTopping(ToppingObjects.jalapenos());
                    break;
                case "6":
                    sandwich.addTopping(ToppingObjects.cucumber());
                    break;
                case "7":
                    sandwich.addTopping(ToppingObjects.pickles());
                    break;
                case "8":
                    sandwich.addTopping(ToppingObjects.guacamole());
                    break;
                case "9":
                    sandwich.addTopping(ToppingObjects.mushrooms());
                    break;
                case "0":
                    toppingSelectionActive = false;
                    break;
                default:
                    System.out.println("Select Provided Options");
            }


        }
    }

    private static void selectPremiumTopping(Sandwich sandwich) {
        boolean premiumToppingValid = false;
        while (!premiumToppingValid) {
            System.out.println("Select a Premium Topping");
            System.out.println("""
                    1) American Cheese
                    2) Provolone
                    3) Cheddar
                    4) Swiss
                    5) Skip Premium
                    """);
            String input = userInput.nextLine();

            switch (input) {
                case "1":
                    sandwich.addTopping(ToppingObjects.americanCheese());
                    premiumToppingValid = true;
                    break;
                case "2":
                    sandwich.addTopping(ToppingObjects.provoloneCheese());
                    premiumToppingValid = true;
                    break;
                case "3":
                    sandwich.addTopping(ToppingObjects.cheddarCheese());
                    premiumToppingValid = true;
                    break;
                case "4":
                    sandwich.addTopping(ToppingObjects.swissCheese());
                    premiumToppingValid = true;
                    break;
                case "5":
                    premiumToppingValid = true;
                    break;
                default:
                    System.out.println("Select Provided Options");
            }
        }
        if (!sandwich.getPremiumToppings().isEmpty()) {
            selectExtraCheese(sandwich);
        }
    }

    private static void selectExtraCheese(Sandwich sandwich) {
        boolean extraCheeseSelectionActive = true;
        while (extraCheeseSelectionActive) {
            System.out.println("""
                    Do you want extra cheese (EXTRA CHARGE APPLIED)
                    1) Yes
                    2) NO
                    """);
            String input = userInput.nextLine();
            switch (input) {
                case "1":
                    sandwich.enableExtraCheese();
                    extraCheeseSelectionActive = false;
                    break;
                case "2":
                    extraCheeseSelectionActive = false;
                    break;
                default:
                    System.out.println("Select provided options");
            }
        }
    }

    private static void selectMeat(Sandwich sandwich) {
        boolean sandwichMeatValid = false;
        while (!sandwichMeatValid) {
            System.out.println("Select Meat options");
            System.out.println("""
                    1) Steak
                    2) Ham
                    3) Salami
                    4) Roast Beef
                    5) Chicken
                    6) Bacon
                    7) Skip Meats
                    """);

            String input = userInput.nextLine();

            switch (input) {
                case "1":
                    sandwich.addTopping(ToppingObjects.steak());
                    sandwichMeatValid = true;
                    break;
                case "2":
                    sandwich.addTopping(ToppingObjects.ham());
                    sandwichMeatValid = true;
                    break;
                case "3":
                    sandwich.addTopping(ToppingObjects.salami());
                    sandwichMeatValid = true;
                    break;
                case "4":
                    sandwich.addTopping(ToppingObjects.roastBeef());
                    sandwichMeatValid = true;
                    break;
                case "5":
                    sandwich.addTopping(ToppingObjects.chicken());
                    sandwichMeatValid = true;
                    break;
                case "6":
                    sandwich.addTopping(ToppingObjects.bacon());
                    sandwichMeatValid = true;
                    break;
                case "7":
                    sandwichMeatValid = true;
                    break;
                default:
                    System.out.println("Select an OPTION");

            }
        }

        if (!sandwich.getMeats().isEmpty()) {
            selectExtraMeat(sandwich);
        }
    }

    private static void selectExtraMeat(Sandwich sandwich) {
        boolean extraMeatSelectionActive = true;
        while (extraMeatSelectionActive) {
            System.out.println("""
                    Do you want extra meat (EXTRA CHARGE APPLIED)
                    1) Yes
                    2) NO
                    """);
            String input = userInput.nextLine();
            switch (input) {
                case "1":
                    sandwich.enableExtraMeat();
                    extraMeatSelectionActive = false;
                    break;
                case "2":
                    extraMeatSelectionActive = false;
                    break;
                default:
                    System.out.println("Select provided options");
            }
        }
    }

    private static Size getSize(Size size) {
        while (size == null) {
            System.out.println("Select Sandwich Size");
            System.out.println("""
                    1) Small
                    2) Medium
                    3) Large
                    """);
            String input = userInput.nextLine();

            switch (input) {
                case "1":
                    size = Size.SMALL;
                    break;
                case "2":
                    size = Size.MEDIUM;
                    break;
                case "3":
                    size = Size.LARGE;
                    break;
                default:
                    System.out.println("Please select from provided options");
            }
        }
        return size;
    }

    private static BreadType getBreadType(BreadType breadType) {
        while (breadType == null) {
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
                    breadType = BreadType.WRAP;
                    break;
                default:
                    System.out.println("Please select from provided option");
            }
        }
        return breadType;
    }
}

