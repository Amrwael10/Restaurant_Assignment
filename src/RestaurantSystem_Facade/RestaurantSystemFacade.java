package RestaurantSystem_Facade;
import Billing.BillGenerator;
import Menu.MultipleMenuTypes_Factory.KidsMenuFactory;
import Menu.MultipleMenuTypes_Factory.NonVegMenuFactory;
import Menu.MultipleMenuTypes_Factory.VegMenuFactory;
import Order.Notification_Observer.OrderNotification;

public class RestaurantSystemFacade {
    VegMenuFactory vegMenuFactory = new VegMenuFactory();
    NonVegMenuFactory nonVegMenuFactory = new NonVegMenuFactory();
    KidsMenuFactory kidsMenuFactory = new KidsMenuFactory();
    OrderNotification notifier = new OrderNotification();
    BillGenerator billGenerator = new BillGenerator();
}
