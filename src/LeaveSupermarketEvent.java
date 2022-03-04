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
        return null;
    }


    @Override
    public String toString() {
        return "EndShoppingEvent{" + getTime() + " cust=" + customer.name
                + " " + (customer.shoppingDuration/60) + '}';
    }
}

