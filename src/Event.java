/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 * BAse class for events
 *
 * @author evenal
 */
public abstract class Event {
    /**
     * When the event happens
     */
    int time;
    Customer customer;


    public Event(int time) {
        this.time = time;
    }


    public int getTime() {
        return time;
    }

    //public String nextEvent() { return this.happen().toString(); };

    public Customer getCustomer() {
        return this.customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    /**
     * Make the changes to the simulated supermarket that happens as a
     * consequence of this event.
     *
     * @return an event that will happen later as a consequence of this, or null
     * if it does not cause any event. You can change the return type to a list
     * of events, if an event could cause more than one event to happen later.
     */
    public abstract Event happen();
}
