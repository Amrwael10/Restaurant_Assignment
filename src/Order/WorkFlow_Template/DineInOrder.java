package Order.WorkFlow_Template;
import Order.Notification_Observer.OrderNotification;
import Billing.BillGenerator;
import PaymentSystem_straegy.CashPayment;
import Menu.MenuItemVariations_AbstractFactory.*;

public class DineInOrder extends OrderWorkflow {
    private final OrderNotification manager;

    public DineInOrder(BillGenerator billing, OrderNotification manager) {
        this.billing = billing;
        this.manager = manager;
    }

    @Override
    protected void displayMenu() {
        System.out.println("Display dine-in menu");
    }

    @Override
    protected void selectItems() {
        order = new OrderBuilder()
                .addItem(new MenuItem("Sample", 5))
                .build();
    }

    @Override
    protected void chooseOrderType() {
        order.setOrderType("DINE-IN");
    }

    @Override
    protected void processPayment() {
        billing.setPaymentStrategy(new CashPayment());
        billing.checkout(order);
    }

    @Override
    protected void placeOrder() {
        manager.notifyObservers(order);
    }
}