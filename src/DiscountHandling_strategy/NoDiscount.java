package DiscountHandling_strategy;

import Order.WorkFlow_Template.Order;

public class NoDiscount implements DiscountStrategy{
    @Override
    public double calculateDiscount(Order order) {
        return order.getTotal();
    }
}
