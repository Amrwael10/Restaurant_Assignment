package Order.WorkFlow_Template;
import Billing.CashPayment;
import Order.Notification_Observer.OrderNotification;
import Menu.MenuItemVariations_AbstractFactory.*;
public class DeliveryOrder extends OrderWorkflow {
    private final OrderNotification notifier;
    public MenuComponent item;
    public DeliveryOrder(OrderNotification notifier) { this.notifier = notifier; }

    @Override
    protected void displayMenu() {
        System.out.println("Displaying menu for Delivery Order");
    }

    @Override
    protected void selectItems() {
        order = new OrderBuilder().addItem(new MenuItem("Sample",5)).build();
    }

    @Override
    protected void chooseOrderType() {
        order.setOrderType("DELIVERY");
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