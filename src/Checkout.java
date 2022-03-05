/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.LinkedList;

/**
 *
 * @author evenal
 */
public class Checkout {
    // amount of time per prouct (to scan barcode)
    int PROD_DURATION = Constants.CHECKOUT_PROD_DURATION;
    // amount of time to pay
    int PAY_DURATION = Constants.CHECKOUT_PAY_DURATION;
    //total time for checkout = PAY_DURATION + PROD_DURATION*customer.numProd

    Customer customer;
    int totalCheckoutDuration;
    LinkedList<Customer> customers;

    SuperMarket shop;
    String name;

    public Checkout(SuperMarket shop, int i) {
        this.shop = shop;
        this.name = "Checkout" + i;
        customers = new LinkedList<Customer>();
    }

    public void addCustomer(Customer c) {
        customers.addLast(c);
    }

    public void removeCustomer() {
        customers.removeFirst();
    }

    public Customer poll() {
        return customers.pollFirst();
    }

    public int getSize() {
        return customers.size();
    }

    public String getName() {
        return this.name;
    }


    public void calculateDuration() {
        if(customer != null) {
            totalCheckoutDuration = PAY_DURATION + (PROD_DURATION * customer.numProducts);
        } else {
            System.err.println("The Customer is NULL.");
        }
    }


}
