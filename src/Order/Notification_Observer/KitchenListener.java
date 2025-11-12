package Order.Notification_Observer;

public class KitchenListener implements OrderObserver {
    @Override
    public void update(String orderDetails) {
        System.out.println("Kitchen, New Order Received: " + orderDetails);
    }
}
