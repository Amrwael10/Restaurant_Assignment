package DiscountHandling_strategy;
import Order.WorkFlow_Template.OrderDetails;
public class DiscountMethod {
    private final DiscountStrategy discount;
    public DiscountMethod(DiscountStrategy discount) {
        this.discount = discount;
    }

    public double calculateDiscount(OrderDetails order) {
        return discount.calculateDiscount(order);
    }
}
