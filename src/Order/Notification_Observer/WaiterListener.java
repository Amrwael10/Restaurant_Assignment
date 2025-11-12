package Order.Notification_Observer;

public class WaiterListener implements OrderObserver {
    @Override
    public void update(String orderDetails) {
        System.out.println("Waiter, Please serve: " + orderDetails);
    }
}
