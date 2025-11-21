package DiscountHandling_strategy;

import Order.WorkFlow_Template.Order;

public class ChickenDiscount implements DiscountStrategy{

    @Override
    public double calculateDiscount(Order order) {
        return order.getTotal() * 0.5; // 50% discount on chicken
    }
}
