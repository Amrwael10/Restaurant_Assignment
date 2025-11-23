import PaymentSystem_straegy.CashPayment;
import RestaurantSystem_Facade.RestaurantSystemFacade;
import Menu.CustomizableAddOns_decorator.CheeseAddOn;
import Menu.MenuItemVariations_AbstractFactory.MenuComponent;
import Order.WorkFlow_Template.OrderDetails;
import DiscountHandling_strategy.*;

public class Main {
    public static void main(String[] args) {
        RestaurantSystemFacade facade = new RestaurantSystemFacade();
        MenuComponent pizza = facade.getMenuItem("veg","pizza","italian");
        pizza = new CheeseAddOn(pizza);
        OrderDetails order = facade.newOrder().addItem(pizza).orderType("DINE-IN").build();
        boolean paid = facade.checkout(order, new CashPayment(), new PizzaDiscount());
        System.out.println("Paid: " + paid);
    }
}