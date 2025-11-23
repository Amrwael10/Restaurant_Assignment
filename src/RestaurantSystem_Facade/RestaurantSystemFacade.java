package RestaurantSystem_Facade;
import Billing.BillGenerator;
import PaymentSystem_straegy.PaymentStrategy;
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
    private final VegMenuFactory vegMenuFactory = new VegMenuFactory();
    private final NonVegMenuFactory nonVegMenuFactory = new NonVegMenuFactory();
    private final KidsMenuFactory kidsMenuFactory = new KidsMenuFactory();
    private final OrderNotification notifier = new OrderNotification();
    private final BillGenerator billGenerator = new BillGenerator();

    public RestaurantSystemFacade() {
        notifier.addObserver(new KitchenListener());
        notifier.addObserver(new WaiterListener());
    }

    // Facade method to get menu items
    public MenuComponent getMenuItem(String family, String type, String variant) {
        MenuFactory f = selectFactory(family);
        if (f == null) return null;

        return switch (type.toLowerCase()) {
            case "pizza" -> f.createPizza(variant);
            case "burger" -> f.createBurger(variant);
            case "beverage" -> f.createBeverage(variant);
            default -> null;
        };
    }

    // Facade method to start a new order
    public OrderBuilder newOrder() {
        return new OrderBuilder();
    }

    // Private helper method to select menu factory
    private MenuFactory selectFactory(String family) {
        return switch (family.toLowerCase()) {
            case "veg" -> vegMenuFactory;
            case "kids" -> kidsMenuFactory;
            case "noneg" -> nonVegMenuFactory;
            default -> null;
        };
    }

    // Facade method to check out an order
    public boolean checkout(OrderDetails order, PaymentStrategy payment, DiscountStrategy discount) {
        billGenerator.setPaymentStrategy(payment);
        billGenerator.setDiscountStrategy(discount);
        boolean success = billGenerator.checkout(order);

        if (success) {
            notifier.notifyObservers(order);
        }
        return success;
    }
}
