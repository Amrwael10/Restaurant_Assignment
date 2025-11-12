package Order.WorkFlow_Template;
import Order.Notification_Observer.OrderNotification;

public class DineInOrder extends OrderWorkflow {
    private final OrderNotification notifier;

    public DineInOrder(OrderNotification notifier) { this.notifier = notifier; }

    @Override
    protected void selectItem() {
        System.out.println("Customer selected item for dine-in: " + item.getName());
    }

    @Override
    protected void notifyKitchenAndWaiter() {
        notifier.notifyObservers("Dine-In Order: " + item.getName());
    }
}