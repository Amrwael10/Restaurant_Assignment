package DiscountHandling_strategy;
import Menu.MenuItemVariations_AbstractFactory.MenuComponent;
import Order.WorkFlow_Template.OrderDetails;

public class BurgerDiscount implements DiscountStrategy{

    @Override
    public double calculateDiscount(OrderDetails order) {
        double discountAmount = 0.0;
        for (MenuComponent item : order.getItems()) {
            String itemName = item.getName().toLowerCase();
            if (itemName.contains("burger")) {
                discountAmount += item.getPrice() * 0.15; // 15% off chicken items
            }
        }
        return discountAmount;
    }
}
