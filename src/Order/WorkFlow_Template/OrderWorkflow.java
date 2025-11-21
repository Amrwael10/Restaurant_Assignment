package Order.WorkFlow_Template;
public abstract class OrderWorkflow {
protected Order order;
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
protected void calculateTotals() { System.out.println("Totals: " + order.getTotal()); }
protected void applyDiscounts() {};
protected abstract void processPayment();
protected void generateReceipt() { System.out.println("Receipt for order: " + order.getId()); }
protected void placeOrder() {};
}
