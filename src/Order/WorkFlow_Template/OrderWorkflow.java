package Order.WorkFlow_Template;

import Billing.BillGenerator;

public abstract class OrderWorkflow {
    protected Order order;
    BillGenerator billing = new BillGenerator();

    public final void process() {
        displayMenu();
        selectItems();
        chooseOrderType();
        calculateTotals();
        applyDiscounts();
        processPayment();
        generateReceipt();
        placeOrder();
    }
        protected abstract void displayMenu();
        protected abstract void selectItems();
        protected abstract void chooseOrderType();
        protected abstract void processPayment();
        protected void calculateTotals() { System.out.println("Totals: " + order.getTotal()); }
        protected void applyDiscounts() {};
        protected void generateReceipt() { System.out.println("Receipt for order: " + order.getId()); }
        protected void placeOrder() {};
}
