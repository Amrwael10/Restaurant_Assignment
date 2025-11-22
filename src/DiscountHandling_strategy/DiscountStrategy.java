package DiscountHandling_strategy;
import Order.WorkFlow_Template.OrderDetails;
public interface DiscountStrategy {
    double calculateDiscount(OrderDetails order);
}
