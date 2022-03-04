/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author evenal
 */
public class SuperMarket {

    public static void main(String[] args) {
        SuperMarket supern = new SuperMarket();
        supern.startSim();
    }

    private int NUM_CHECKOUTS = Constants.SM_NUM_CHECKOUTS;
    private int NUM_CUSTOMERS = Constants.SM_NUM_CUSTOMERS;

    Checkout[] checkouts;
    List<Customer> customers;
    List<Event> init;


    public SuperMarket() {
        checkouts = new Checkout[NUM_CHECKOUTS];

        for (int i = 0; i < NUM_CHECKOUTS; i++)
            checkouts[i] = new Checkout(this, i);

        customers = new ArrayList<>();
        init = new ArrayList<Event>();

        for (int i = 0; i < NUM_CUSTOMERS; i++) {
            Customer c = new Customer(this, i, checkouts);
            init.add(new EnterShopEvent(c));
            customers.add(c);
        }
    }

    public Checkout[] getCheckouts() {
        return checkouts;
    }


    public void startSim() {
        EventSim sim = EventSim.getInstance();
        sim.setup(init);
        sim.run();
    }
}
