public class StandInQueueEvent extends Event {
    Checkout checkout;
    Customer customer;
    int waitDuration;

    public StandInQueueEvent(int time, Checkout checkout, Customer customer) {
        super(time);
        //System.out.println(Constants.ANSI_BRIGHT_CYAN + "Waiting.." + Constants.ANSI_RESET);
        this.checkout = checkout;
        this.customer = customer;

    }

    @Override
    public Event happen() {
        checkout.removeCustomer();
        return new CheckoutEvent(getTime(), checkout, customer);
    }

    @Override
    public String toString() {
        return "StandInQueueEvent{" + getTime() + " cust=" + customer.name
                + " " + customer.shoppingDuration + '}';
    }
}
