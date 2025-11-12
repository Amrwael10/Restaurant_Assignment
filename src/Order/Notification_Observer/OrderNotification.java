package Order.Notification_Observer;
import java.util.ArrayList;
import java.util.List;

public class OrderNotification {
    private final List<OrderObserver> observers;

    public OrderNotification() {
        this.observers = new ArrayList<>();
    }

    public void addObserver(OrderObserver observer) {
        observers.add(observer);
    }

    public void notifyObservers(String orderDetails) {
        observers.forEach(observer -> observer.update(orderDetails));
    }
}
