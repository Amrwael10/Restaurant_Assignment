package Order.WorkFlow_Template;
import Menu.MenuItemVariations_AbstractFactory.MenuItem;
import Order.Notification_Observer.OrderNotification;

public class TakeAwayOrder extends OrderWorkflow{
    private final OrderNotification notifier;
    MenuItem item;
    public TakeAwayOrder(OrderNotification notifier) { this.notifier = notifier; }

    @Override
    protected void selectItems() {
        System.out.println("Customer selected item for delivery: " + item.getName());
    }

    @Override
    protected void placeOrder() {
        notifier.notifyObservers(order);
    }
}
