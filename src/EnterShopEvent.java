/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 * A customer enters the shop
 *
 * @author evenal
 */
public class EnterShopEvent extends Event {
    Customer customer;


    public EnterShopEvent(Customer customer) {
        super(customer.beginShoppingTime);
        this.customer = customer;
        //System.out.println("Start time: " + EventSim.getClock());
        //customer.totalTime = customer.enterShopTime;
        //System.out.println(customer.name + " Enters shop at time " + customer.totalTime);
    }


    @Override
    public Event happen() {
        if (customer.numProducts > 0) {
            return new FindCheckoutEvent(customer.endShoppingTime, customer);
        } else {
            return new LeaveSupermarketEvent(customer.endShoppingTime, customer);
        }
    }

    @Override
    public String toString() {
        return customer.name + " enters the supermarket";
       /* return "EnterShopEvent{" + getTime() + " cust=" + customer.name
                + " " + customer.shoppingDuration + '}';*/
    }
}
