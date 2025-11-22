package Order.WorkFlow_Template;
import Menu.MenuItemVariations_AbstractFactory.MenuComponent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class OrderDetails {
    private UUID id = UUID.randomUUID();
    private List<MenuComponent> items = new ArrayList<>();
    private String orderType; // dine-in, delivery, takeaway
    public UUID getId() { return id; }
    public void addItem(MenuComponent item) { items.add(item); }
    public List<MenuComponent> getItems() { return Collections.unmodifiableList(items); }
    public double getTotal() {
    return items.stream().mapToDouble(MenuComponent::getPrice).sum();
    }
    public void setOrderType(String type) { this.orderType = type; }
    public String getOrderType() { return orderType; };
}
