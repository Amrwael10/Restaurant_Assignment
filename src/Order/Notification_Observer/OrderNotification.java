package Order.Notification_Observer;
import java.util.ArrayList;
import java.util.List;
import Order.WorkFlow_Template.*;
public class OrderNotification {
    private final List<OrderObserver> observers;

    public OrderNotification() {
        this.observers = new ArrayList<>();
    }

    public void addObserver(OrderObserver observer) {
        observers.add(observer);
    }
    
    public void notifyObservers(Order order) {
        observers.forEach(observer -> observer.update(order));
    }
}
