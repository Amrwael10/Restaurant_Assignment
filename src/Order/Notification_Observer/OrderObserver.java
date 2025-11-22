package Order.Notification_Observer;
import Order.WorkFlow_Template.OrderDetails;
public interface OrderObserver {
    void update(OrderDetails order);
}
