package DiscountHandling_strategy;

import Order.WorkFlow_Template.Order;

public class PizzaDiscount implements DiscountStrategy{
    @Override
    public double calculateDiscount(Order order) {
        return order.getTotal() * 0.4; // 40% discount on pizza
    }
}
