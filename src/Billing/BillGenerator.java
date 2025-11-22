package Billing;
import Order.WorkFlow_Template.OrderDetails;
import DiscountHandling_strategy.*;

public class BillGenerator {
    private PaymentStrategy paymentStrategy;
    private DiscountStrategy discountStrategy = new NoDiscount();
    public void setPaymentStrategy(PaymentStrategy p){ this.paymentStrategy = p; }
    public void setDiscountStrategy(DiscountStrategy d){ this.discountStrategy = d; }
    public boolean checkout(OrderDetails order){
        double total = order.getTotal();
        double discount = discountStrategy.calculateDiscount(order);
        double finalAmount = total - discount;
        if (paymentStrategy == null) throw new IllegalStateException("Payment strategy not set");
        paymentStrategy.pay(finalAmount);
        return true;
    }
}
