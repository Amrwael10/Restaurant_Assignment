package Order.Notification_Observer;
import Order.WorkFlow_Template.OrderDetails;
public class WaiterListener implements OrderObserver {
    @Override
    public void update(OrderDetails order) {
        System.out.println("Waiter, Please serve: " + order.getId());
    }
}
