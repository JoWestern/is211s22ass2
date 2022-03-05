/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author evenal
 */
public class Customer {
    // customer will pick a random number of products between these two values
    int MAX_PRODUCTS = Constants.CUSTOMER_MAX_PRODUCTS;
    int MIN_PRODUCTS = Constants.CUSTOMER_MIN_PRODUCTS;

    // customer will spend ranom amount of time between these values before
    // going to check out

    SuperMarket shop;
    String name;

    int beginShoppingTime;
    int shoppingDuration;
    int endShoppingTime;
    int numProducts;
    Checkout[] checkouts;
    //int longestQueue;
    //String longestQueueName;
    Checkout shortestQueue;
    int enterQueueTime;
    int queueWaitDuration;
    int checkoutDuration;
    int waitTime;
    int totalTime;
    int leaveTime;

    public Customer(SuperMarket shop, int i, Checkout[] checkouts) {
        this.shop = shop;
        this.checkouts = checkouts;
        name = "Cust" + i;
        beginShoppingTime = i;
        numProducts = EventSim.nextInt(MIN_PRODUCTS, MAX_PRODUCTS);

        fixTime();
    }

    public void fixTime() {
        shoppingDuration = numProducts * Constants.TIME_PER_PRODUCT;
        endShoppingTime = beginShoppingTime + shoppingDuration;
    }

    public Checkout[] getCheckouts() {
        return checkouts;
    }
}
