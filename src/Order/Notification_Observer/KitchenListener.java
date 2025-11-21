package Order.Notification_Observer;
import Order.WorkFlow_Template.Order;
public class KitchenListener implements OrderObserver {
    @Override
    public void update(Order order) {
        System.out.println("Kitchen, New Order Received: " + order.getId());
    }
}
