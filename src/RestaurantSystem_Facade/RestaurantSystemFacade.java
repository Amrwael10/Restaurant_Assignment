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
            case "nonveg" -> nonVegMenuFactory;  // FIXED: was "noneg"
            default -> null;
        };
    }

    // Facade method to notify staff (called when items are added)
    public void notifyStaff(OrderDetails order) {
        notifier.notifyObservers(order);
    }

    // Facade method to check out an order
    public boolean checkout(OrderDetails order, PaymentStrategy payment, DiscountStrategy discount) {
        billGenerator.setPaymentStrategy(payment);
        billGenerator.setDiscountStrategy(discount);
        boolean success = billGenerator.checkout(order);

        if (success) {
            // Final notification at checkout
            System.out.println("📢 Final order confirmation sent to Kitchen and Waiter!");
            notifier.notifyObservers(order);
        }
        return success;
    }

    // Display full menu
    public void displayFullMenu() {
        System.out.println("\n========== RESTAURANT MENU ==========");
        System.out.println("\n--- VEGETARIAN MENU ---");
        System.out.println("Pizzas: Veg Italian Pizza ($8.0), Veg Classic Pizza ($6.5)");
        System.out.println("Burgers: Veg Burger ($5.0)");
        System.out.println("Beverages: Soft Drink ($1.5)");

        System.out.println("\n--- NON-VEGETARIAN MENU ---");
        System.out.println("Pizzas: Eastern Chicken Pizza ($9.0), Chicken Classic Pizza ($8.5)");
        System.out.println("Burgers: Classic Burger ($6.0)");
        System.out.println("Beverages: Soft Drink ($1.5)");

        System.out.println("\n--- KIDS MENU ---");
        System.out.println("Pizzas: Kids Pizza ($4.0)");
        System.out.println("Burgers: Kids Burger ($3.5)");
        System.out.println("Beverages: Juice ($1.0)");

        System.out.println("\n--- ADD-ONS (Pizza & Burgers) ---");
        System.out.println("Extra Cheese (+$1.5)");
        System.out.println("Extra Sauce (+$0.75)");
        System.out.println("Extra Toppings (+$2.0)");

        System.out.println("\n--- BEVERAGE FLAVORS ---");
        System.out.println("Apple, Orange, Mango, Pineapple (No extra charge)");
        System.out.println("=====================================\n");
    }
}