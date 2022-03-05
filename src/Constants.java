public class Constants {
    // default value 2
    public static final int SM_NUM_CHECKOUTS = 2;
    // default value: 50
    public static final int SM_NUM_CUSTOMERS = 20;
    // default value: 200
    public static final int CUSTOMER_MAX_PRODUCTS = 50;
    // default value: 0
    public static final int CUSTOMER_MIN_PRODUCTS = 2;

    public static final int CUSTOMER_MAX_SHOPPING_TIME = 10800;
    public static final int TIME_PER_PRODUCT = 10;

    //Queues
    // Statisk mengde tid for å se etter kasse. Uavhengig av om det er kø eller ikke.
    public static final int CUSTOMER_FIND_QUEUE_DURATION = 5;

    //Checkout
    public static final int CHECKOUT_PROD_DURATION = 2;
    public static final int CHECKOUT_PAY_DURATION = 10;
}
