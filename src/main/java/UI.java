import java.util.Scanner;

public class UI {
    static Scanner userInput = new Scanner(System.in);


    public static void homeScreen() {
        while (true) {
            System.out.println("""
                    =================================
                          WELCOME TO THE SHOP
                    =================================
                    
                    Please select an option:
                    
                    1) New Order
                    0) Exit
                    
                    >""");
            String input = userInput.nextLine();

            switch (input) {
                case "1":
                    orderScreen();
                    break;
                case "0":
                    System.out.println("EXITING PROGRAM...");
                    System.exit(0);
                default:
                    System.out.println("INVALID OPTION — TRY AGAIN");
            }
        }


    }

    public static void orderScreen() {
        Order currentOrder = new Order();
        boolean active = true;

        while (active) {
            System.out.println("""
                    =================================
                           ORDER MENU
                    =================================
                    
                    Select an option:
                    
                    1) Add Sandwich
                    2) Add Drink
                    3) Add Side
                    4) Checkout
                    0) Cancel Order
                    
                    >""");
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
                    active = false;
                    break;
                case "0":
                    active = false;
                    System.out.println("Clearing order returning to main menu");
                    break;
                default:
                    System.out.println("INVALID OPTION — TRY AGAIN");
                    break;
            }
        }
    }

    private static void checkout(Order currentOrder) {

        if (!currentOrder.isValidOrder()) {
            System.out.println("Order must contain a sandwich or side");
            return;
        }

        System.out.println("""
                =================================
                          YOUR ORDER
                =================================
                """);

        System.out.println(currentOrder.getOrderInfo());

        System.out.println("""
                =================================
                      CONFIRM YOUR ORDER
                =================================
                
                1) Yes
                2) No
                
                >""");

        String input = userInput.nextLine();

        switch (input) {

            case "1":
                System.out.println("""
                        =================================
                           ORDER COMPLETE
                        =================================
                        
                        Thank you for your purchase.
                        Generating receipt...
                        """);
                ReceiptManager.writeReceipt(currentOrder);
                currentOrder.clearOrder();
                return;
            case "2":
                return;
            default:
                System.out.println("INVALID OPTION — TRY AGAIN");

        }

    }

    private static void addMainSide(Order currentOrder) {
        String name = "";

        boolean activeSideMenu = true;
        while (activeSideMenu) {
            System.out.println("""
                    =================================
                             SELECT A SIDE
                    =================================
                    
                    1) Fries
                    2) Mozzarella Sticks
                    3) Popcorn Chicken
                    4) Tomato Soup
                    0) Return to Order Screen
                    
                    >""");
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
                    System.out.println("INVALID OPTION — TRY AGAIN");
            }
        }

        MainSide currentSide = new MainSide(name);

        System.out.println("""
                =================================
                       ADD THIS SIDE?
                =================================
                
                1) Yes
                2) No
                
                >""");
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

        System.out.println("""
                =================================
                      SELECT DRINK SIZE
                =================================
                
                1) Small
                2) Medium
                3) Large
                
                >""");
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

        System.out.println("""
                =================================
                      SELECT DRINK FLAVOR
                =================================
                
                1) Pepsi
                2) Sprite
                3) Coca-Cola
                4) Dr Pepper
                
                >""");

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
                System.out.println("INVALID OPTION — TRY AGAIN");
        }

        Drink currentDrink = new Drink(name, size);

        System.out.println("""
                =================================
                       YOUR DRINK
                =================================
                """);

        System.out.println(currentDrink);

        System.out.println("""
                =================================
                ADD DRINK TO YOUR ORDER?
                =================================
                
                1) Yes
                2) No
                
                >""");

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
        selectToast(sandwich);

        previewSandwich(sandwich);

        confirmOrder(currentOrder, sandwich);
    }

    private static void selectToast(Sandwich sandwich) {

        boolean toastSelectionActive = true;
        while (toastSelectionActive) {
            System.out.println("""
                    =================================
                       TOASTED SANDWICH OPTION
                    =================================
                    
                    Do you want your sandwich toasted?
                    
                    1) Yes
                    2) No
                    
                    >""");
            String input = userInput.nextLine();
            switch (input) {
                case "1":
                    sandwich.setToasted(true);
                    toastSelectionActive = false;
                    break;
                case "2":
                    toastSelectionActive = false;
                    break;
                default:
                    System.out.println("INVALID OPTION — TRY AGAIN");
            }
        }
    }

    private static void confirmOrder(Order currentOrder, Sandwich sandwich) {
        boolean confirmSandwichActive = true;
        while (confirmSandwichActive) {
            System.out.println("""
                    =================================
                       ADD SANDWICH TO ORDER?
                    =================================
                    
                    Would you like to keep this sandwich?
                    
                    1) Yes
                    2) No
                    
                    >""");

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
                    System.out.println("INVALID OPTION — TRY AGAIN");
            }
        }
    }

    private static void previewSandwich(Sandwich sandwich) {
        System.out.println("""
                =================================
                        YOUR SANDWICH
                =================================
                """);

        System.out.println(sandwich);
    }

    private static void selectCondiments(Sandwich sandwich) {
        boolean condimentSelectionActive = false;
        while (!condimentSelectionActive) {
            System.out.println("""
                    =================================
                          SELECT A SAUCE
                    =================================
                    
                    1) Mayo
                    2) Ketchup
                    3) All Sauces
                    
                    >""");
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
                    System.out.println("INVALID OPTION — TRY AGAIN");


            }
        }
    }

    private static void selectOtherTopping(Sandwich sandwich) {
        boolean toppingSelectionActive = true;
        while (toppingSelectionActive) {
            System.out.println("""
                    =================================
                       SELECT EXTRA TOPPINGS
                    =================================
                    
                    1) Lettuce        2) Peppers
                    3) Onions         4) Tomatoes
                    5) Jalapenos      6) Cucumbers
                    7) Pickles        8) Guacamole
                    9) Mushrooms      0) Next Menu
                    
                    >""");

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
                    System.out.println("INVALID OPTION — TRY AGAIN");
            }


        }
    }

    private static void selectPremiumTopping(Sandwich sandwich) {
        boolean premiumToppingValid = false;
        while (!premiumToppingValid) {
            System.out.println("""
                    =================================
                     SELECT PREMIUM TOPPINGS
                    =================================
                    
                    1) American Cheese
                    2) Provolone
                    3) Cheddar
                    4) Swiss
                    5) Skip Premium
                    
                    >""");
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
                    System.out.println("INVALID OPTION — TRY AGAIN");
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
                    =================================
                          EXTRA CHEESE OPTION
                    =================================
                    
                    Do you want extra cheese?
                    (Extra charge applied)
                    
                    1) Yes
                    2) No
                    
                    >""");
            String input = userInput.nextLine();
            switch (input) {
                case "1":
                    sandwich.setExtraCheese(true);
                    extraCheeseSelectionActive = false;
                    break;
                case "2":
                    extraCheeseSelectionActive = false;
                    break;
                default:
                    System.out.println("INVALID OPTION — TRY AGAIN");
            }
        }
    }

    private static void selectMeat(Sandwich sandwich) {
        boolean sandwichMeatValid = false;
        while (!sandwichMeatValid) {
            System.out.println("""
                    =================================
                         SELECT MEAT OPTIONS
                    =================================
                    
                    1) Steak         2) Ham
                    3) Salami        4) Roast Beef
                    5) Chicken       6) Bacon
                    7) Skip Meats
                    
                    >""");

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
                    System.out.println("INVALID OPTION — TRY AGAIN");

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
                    =================================
                          EXTRA MEAT OPTION
                    =================================
                    
                    Do you want extra meat?
                    (Extra charge applied)
                    
                    1) Yes
                    2) No
                    
                    >""");
            String input = userInput.nextLine();
            switch (input) {
                case "1":
                    sandwich.setExtraMeat(true);
                    extraMeatSelectionActive = false;
                    break;
                case "2":
                    extraMeatSelectionActive = false;
                    break;
                default:
                    System.out.println("INVALID OPTION — TRY AGAIN");
            }
        }
    }

    private static Size getSize(Size size) {
        while (size == null) {
            System.out.println("""
                    =================================
                       SELECT SANDWICH SIZE
                    =================================
                    
                    1) Small
                    2) Medium
                    3) Large
                    
                    >""");
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
                    System.out.println("INVALID OPTION — TRY AGAIN");
            }
        }
        return size;
    }

    private static BreadType getBreadType(BreadType breadType) {
        while (breadType == null) {
            System.out.println("""
                    =================================
                         SELECT YOUR BREAD
                    =================================
                    
                    1) White bread
                    2) Wheat bread
                    3) Rye bread
                    4) Wrap
                    
                    >""");
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
                    System.out.println("INVALID OPTION — TRY AGAIN");
            }
        }
        return breadType;
    }
}

