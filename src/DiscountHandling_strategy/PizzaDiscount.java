package DiscountHandling_strategy;
import Menu.MenuItemVariations_AbstractFactory.MenuComponent;
import Order.WorkFlow_Template.OrderDetails;

public class PizzaDiscount implements DiscountStrategy{
    @Override
    public double calculateDiscount(OrderDetails order) {
        double discountAmount = 0.0;
        for (MenuComponent item : order.getItems()) {
            String itemName = item.getName().toLowerCase();
            if (itemName.contains("pizza")) {
                discountAmount += item.getPrice() * 0.10; // 10% off pizza items
            }
        }
        return discountAmount;
    }
}
