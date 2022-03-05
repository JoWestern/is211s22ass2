public class LeaveSupermarketEvent extends Event {
    Customer customer;
    int exitTime;

    public LeaveSupermarketEvent(int time, Customer customer) {
        super(EventSim.getClock() + customer.shoppingDuration);
        this.customer = customer;
        this.exitTime = time;
    }

    @Override
    public Event happen() {
        customer.leaveTime = exitTime;

        //For å se hvilken kø som var lengst da kunden skulle stille seg i kø, kan brukes til å finne bottlenecks.
        //System.out.println(customer.name + " longest line during checkout "+ customer.longestQueueName + " size: " + customer.longestQueue);
        return null;
    }


    @Override
    public String toString() {
        return customer.name + " is done and leaves the supermarket";
        /*return "LeaveSupermarketEvent{" + getTime() + " cust=" + customer.name
                + " " + customer.shoppingDuration + '}'; */
    }
}

