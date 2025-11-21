package Order.WorkFlow_Template;
import Order.Notification_Observer.OrderNotification;
import Menu.MenuItemVariations_AbstractFactory.*;
public class DeliveryOrder extends OrderWorkflow {
    private final OrderNotification notifier;
    MenuComponent item;
    public DeliveryOrder(OrderNotification notifier) { this.notifier = notifier; }

    @Override
    protected void selectItems() {
        System.out.println("Customer selected item for delivery: " + item.getName());
    }

    @Override
    protected void placeOrder() {
        notifier.notifyObservers(order);
    }
}