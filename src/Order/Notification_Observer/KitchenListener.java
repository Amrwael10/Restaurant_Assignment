package Order.Notification_Observer;
import Order.WorkFlow_Template.OrderDetails;
public class KitchenListener implements OrderObserver {
    @Override
    public void update(OrderDetails order) {
        System.out.println("Kitchen, New Order Received: " + order.getId());
    }
}
