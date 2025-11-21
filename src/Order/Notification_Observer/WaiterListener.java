package Order.Notification_Observer;
import Order.WorkFlow_Template.Order;
public class WaiterListener implements OrderObserver {
    @Override
    public void update(Order order) {
        System.out.println("Waiter, Please serve: " + order.getId());
    }
}
