public class ToppingObjects {

    //region MEAT Toppings
    public static Topping bacon(){
        return new Topping(ToppingName.BACON,ToppingType.MEAT);
    }

    public static Topping steak() {
        return new Topping(ToppingName.STEAK, ToppingType.MEAT);
    }

    public static Topping ham() {
        return new Topping(ToppingName.HAM, ToppingType.MEAT);
    }

    public static Topping salami() {
        return new Topping(ToppingName.SALAMI, ToppingType.MEAT);
    }

    public static Topping roastBeef() {
        return new Topping(ToppingName.ROAST_BEEF, ToppingType.MEAT);
    }

    public static Topping chicken() {
        return new Topping(ToppingName.CHICKEN, ToppingType.MEAT);
    }
    // endregion

    //region PREMIUM Toppings
    public static Topping americanCheese() {
        return new Topping(ToppingName.AMERICAN_CHEESE, ToppingType.PREMIUM);
    }

    public static Topping provoloneCheese() {
        return new Topping(ToppingName.PROVOLONE, ToppingType.PREMIUM);
    }

    public static Topping cheddarCheese() {
        return new Topping(ToppingName.CHEDDAR, ToppingType.PREMIUM);
    }

    public static Topping swissCheese() {
        return new Topping(ToppingName.SWISS, ToppingType.PREMIUM);
    }
    //endregion

    //region OTHER Toppings
    public static Topping lettuce() {
        return new Topping(ToppingName.LETTUCE, ToppingType.OTHER);
    }

    public static Topping peppers() {
        return new Topping(ToppingName.PEPPERS, ToppingType.OTHER);
    }

    public static Topping onions() {
        return new Topping(ToppingName.ONIONS, ToppingType.OTHER);
    }
    public static Topping tomatoes(){
        return new Topping(ToppingName.TOMATOES,ToppingType.OTHER);
    }

    public static Topping jalapenos(){
        return new Topping(ToppingName.JALAPENOS,ToppingType.OTHER);
    }

    public static Topping cucumber(){
        return new Topping(ToppingName.CUCUMBERS,ToppingType.OTHER);
    }

    public static Topping pickles(){
        return new Topping(ToppingName.PICKLES,ToppingType.OTHER);
    }

    public static Topping guacamole(){
        return new Topping(ToppingName.GUACAMOLE,ToppingType.OTHER);
    }

    public static Topping mushrooms(){
        return new Topping(ToppingName.MUSHROOMS,ToppingType.OTHER);
    }
    //endregion
}
