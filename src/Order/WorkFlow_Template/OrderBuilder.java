package Order.WorkFlow_Template;
import Menu.MenuItemVariations_AbstractFactory.*;
public class OrderBuilder {
    private final OrderDetails order = new OrderDetails();


    public OrderBuilder addItem(MenuComponent item){ order.addItem(item); return this; }
    public OrderBuilder orderType(String type){ order.setOrderType(type); return this; }
    public OrderDetails build(){ return order; }
}
