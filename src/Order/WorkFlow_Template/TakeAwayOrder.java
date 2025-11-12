package Order.WorkFlow_Template;
import Order.Notification_Observer.OrderNotification;

public class TakeAwayOrder extends OrderWorkflow{
    private final OrderNotification notifier;

    public TakeAwayOrder(OrderNotification notifier) { this.notifier = notifier; }

    @Override
    protected void selectItem() {
        System.out.println("Customer selected item for delivery: " + item.getName());
    }

    @Override
    protected void notifyKitchenAndWaiter() {
        notifier.notifyObservers("Delivery Order: " + item.getName());
    }
}
