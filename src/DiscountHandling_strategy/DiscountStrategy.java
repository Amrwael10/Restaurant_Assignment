package DiscountHandling_strategy;
import Order.WorkFlow_Template.Order;
public interface DiscountStrategy {
    public double calculateDiscount(Order order);
}
