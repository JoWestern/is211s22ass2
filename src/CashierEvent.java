public class CashierEvent extends Event {
    Checkout checkout;
    Customer customer;

    public CashierEvent(int time, Checkout checkout, Customer customer) {
        super(time);
        this.checkout = checkout;
        this.customer = customer;
    }

    @Override
    public Event happen() {
        checkout.customer = null;
        return new LeaveSupermarketEvent(getTime(), customer);
    }

    @Override
    public String toString() {
        return "CashierEvent{" + getTime() + " cust=" + customer.name
                + " " + customer.totalTime + '}';
    }
}
