public class FindCheckoutEvent extends Event {
    Customer customer;

    public FindCheckoutEvent(int time, Customer customer) {
        super(time);
        this.customer = customer;
    }

    @Override
    public Event happen() {
        //customer.totalTime += customer.enterQueueTime;
        Checkout checkout = findSmallestQueue(customer.checkouts);
        //Checkout longestCheckoutQueue = findLargestQueue(customer.checkouts);
        customer.shortestQueue = checkout;

        int waitTime = 0;
        for (Customer cust : checkout.customers) {
            waitTime += getCheckoutDuration(cust);
        }
        if (checkout.customer != null) {
            waitTime += getCheckoutDuration(checkout.customer);
        }

        //customer.longestQueue = longestCheckoutQueue.getSize();
        //customer.longestQueueName = longestCheckoutQueue.getName();
        checkout.addCustomer(customer);
        return new StandInQueueEvent(getTime() + waitTime, checkout, customer);
    }

    private Checkout findSmallestQueue(Checkout[] checkouts) {
        if(checkouts.length == 1) {
            return checkouts[0];
        }

        int smallestQueue = 255;
        int smallestQueueIndex = 0;

        for(int i = 0; i < checkouts.length; i++) {
            int size = checkouts[i].customers.size();
            if(size < smallestQueue) {
                smallestQueue = size;
                smallestQueueIndex = i;
            }
        }
        return checkouts[smallestQueueIndex];
    }

    /*private Checkout findLargestQueue(Checkout[] checkouts) {
        if(checkouts.length == 1) {
            return checkouts[0];
        }

        int largestQueue = 1;
        int largestQueueIndex = 0;

        for (int i = 0; i < checkouts.length; i++) {
            int size = checkouts[i].customers.size();
            if (size > largestQueue) {
                largestQueue = size;
                largestQueueIndex = i;
            }
        }
        return checkouts[largestQueueIndex];
    } */

    private int getCheckoutDuration(Customer customer) {
        int waitTime = Constants.CHECKOUT_PAY_DURATION + (Constants.CHECKOUT_PROD_DURATION * customer.numProducts);
        return waitTime;
    }

    @Override
    public String toString() {
        return customer.name + " has picked " + customer.numProducts + " products, and looks for a checkout";
        /*return "FindCheckoutEvent{" + getTime() + " cust=" + customer.name
                + " " + customer.shoppingDuration + '}';*/
    }
}
