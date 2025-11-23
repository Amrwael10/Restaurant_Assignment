package Order.WorkFlow_Template;
import Menu.MenuItemVariations_AbstractFactory.MenuComponent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class OrderDetails {
    private static final AtomicInteger orderCounter = new AtomicInteger(0);

    private final int id;
    private final List<MenuComponent> items = new ArrayList<>();
    private String orderType;

    public OrderDetails() {
        this.id = orderCounter.incrementAndGet();
    }

    public int getId() {
        return id;
    }

    public void addItem(MenuComponent item) {
        items.add(item);
    }

    public List<MenuComponent> getItems() {
        return Collections.unmodifiableList(items);
    }

    public double getTotal() {
        return items.stream().mapToDouble(MenuComponent::getPrice).sum();
    }

    public void setOrderType(String type) {
        this.orderType = type;
    }

    public String getOrderType() {
        return orderType;
    }
}