package Order.WorkFlow_Template;
import Menu.MenuItemVariations_AbstractFactory.*;
public class OrderBuilder {
    private final Order order = new Order();


    public OrderBuilder addItem(MenuItem item){ order.addItem(item); return this; }
    public OrderBuilder orderType(String type){ order.setOrderType(type); return this; }
    public Order build(){ return order; }
}
