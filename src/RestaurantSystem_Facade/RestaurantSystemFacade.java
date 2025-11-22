package RestaurantSystem_Facade;
import Billing.BillGenerator;
import Billing.PaymentStrategy;
import DiscountHandling_strategy.DiscountStrategy;
import Menu.MenuItemVariations_AbstractFactory.MenuComponent;
import Menu.MultipleMenuTypes_Factory.KidsMenuFactory;
import Menu.MultipleMenuTypes_Factory.MenuFactory;
import Menu.MultipleMenuTypes_Factory.NonVegMenuFactory;
import Menu.MultipleMenuTypes_Factory.VegMenuFactory;
import Order.Notification_Observer.KitchenListener;
import Order.Notification_Observer.OrderNotification;
import Order.Notification_Observer.WaiterListener;
import Order.WorkFlow_Template.OrderBuilder;
import Order.WorkFlow_Template.OrderDetails;
public class RestaurantSystemFacade {
    VegMenuFactory vegMenuFactory = new VegMenuFactory();
    NonVegMenuFactory nonVegMenuFactory = new NonVegMenuFactory();
    KidsMenuFactory kidsMenuFactory = new KidsMenuFactory();
    OrderNotification notifier = new OrderNotification();
    BillGenerator billGenerator = new BillGenerator();
    public RestaurantSystemFacade() {
    notifier.addObserver(new KitchenListener());
    notifier.addObserver(new WaiterListener());
    }
    public MenuComponent getMenuItem(String family, String type, String variant) {
        MenuFactory f = selectFactory(family);
        switch(type.toLowerCase()){
            case "pizza": return f.createPizza(variant);
            case "burger": return f.createBurger(variant);
            case "beverage": return f.createBeverage(variant);
            default: return null;
        }
    }

    private MenuFactory selectFactory(String family){
        if (family.equalsIgnoreCase("veg")) return vegMenuFactory;
        if (family.equalsIgnoreCase("kids")) return kidsMenuFactory;
        return nonVegMenuFactory;
    }
    public OrderBuilder newOrder(){
        return new OrderBuilder();
    }
    public boolean checkout(OrderDetails order,PaymentStrategy p, DiscountStrategy d){
    billGenerator.setPaymentStrategy(p);
    billGenerator.setDiscountStrategy(d);
    boolean ok = billGenerator.checkout(order);
    if (ok) notifier.notifyObservers(order);
    return ok;
    }
}

