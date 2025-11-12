package Order.WorkFlow_Template;
import Order.Notification_Observer.OrderNotification;

public class DeliveryOrder extends OrderWorkflow {
    private final OrderNotification notifier;

    public DeliveryOrder(OrderNotification notifier) { this.notifier = notifier; }

    @Override
    protected void selectItem() {
        System.out.println("Customer selected item for delivery: " + item.getName());
    }

    @Override
    protected void notifyKitchenAndWaiter() {
        notifier.notifyObservers("Delivery Order: " + item.getName());
    }
}