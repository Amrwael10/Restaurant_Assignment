package Order.WorkFlow_Template;
import Billing.CashPayment;
import Menu.MenuItemVariations_AbstractFactory.MenuItem;
import Order.Notification_Observer.OrderNotification;

public class TakeAwayOrder extends OrderWorkflow{
    private final OrderNotification notifier;
    public MenuItem item;
    public TakeAwayOrder(OrderNotification notifier) { this.notifier = notifier; }

    @Override
    protected void displayMenu() {
        System.out.println("Displaying menu for Take-Away Order");
    }

    @Override
    protected void selectItems() {
        order = new OrderBuilder().addItem(new MenuItem("Sample",5)).build();
    }

    @Override
    protected void chooseOrderType() {
        order.setOrderType("TAKE-AWAY");
    }

    @Override
    protected void processPayment() {
        billing.setPaymentStrategy(new CashPayment());
        billing.checkout(order);
    }

    @Override
    protected void placeOrder() {
        notifier.notifyObservers(order);
    }
}
