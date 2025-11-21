package Order.Notification_Observer;
import Order.WorkFlow_Template.Order;
public interface OrderObserver {
    void update(Order order);
}
