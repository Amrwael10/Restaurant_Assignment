package DiscountHandling_strategy;

import Order.WorkFlow_Template.OrderDetails;

public class ChickenDiscount implements DiscountStrategy{

    @Override
    public double calculateDiscount(OrderDetails order) {
        return order.getTotal() * 0.5; // 50% discount on chicken
    }
}
