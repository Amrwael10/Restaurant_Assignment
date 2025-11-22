package DiscountHandling_strategy;

import Order.WorkFlow_Template.OrderDetails;

public class PizzaDiscount implements DiscountStrategy{
    @Override
    public double calculateDiscount(OrderDetails order) {
        return order.getTotal() * 0.4; // 40% discount on pizza
    }
}
