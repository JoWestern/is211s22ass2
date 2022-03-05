/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 * A customer finishes shopping and heads for the checkout with the shortest
 * queue
 *
 * @author evenal
 */

public class CheckoutEvent extends Event {
    Customer customer;
    Checkout checkout;

    public CheckoutEvent(int time, Checkout checkout, Customer customer) {
        super(time);
        this.customer = customer;
        this.checkout = checkout;
        checkout.customer = customer;
    }

    @Override
    public Event happen() {
        //customer.queueWaitDuration = EventSim.getClock() - customer.enterQueueTime;
        //System.out.println(customer.name + " has been in queue for: " + customer.queueWaitDuration + " Total time: " + customer.totalTime);

        // Returns a new checkoutEvent
        //customer.totalTime = EventSim.getClock() + customer.enterQueueTime + customer.productPickingDuration + customer.checkoutDuration;
        //System.out.println(customer.name + " enters queue at time " + customer.totalTime);
        //return new CashierEvent(getTime() + getPayTime(), this.checkout, this.customer);

        checkout.customer = null;
        return new LeaveSupermarketEvent(getTime(), customer);
    }

    private int getPayTime() {
        int payTime = checkout.PAY_DURATION + (customer.numProducts * checkout.PROD_DURATION);
        return payTime;
    }


    @Override
    public String toString() {
        return customer.name + " starts checkout and pays";
        /*return "CheckoutEvent{" + getTime() + " cust=" + customer.name
                + " " + customer.totalTime + '}'; */
    }
}
