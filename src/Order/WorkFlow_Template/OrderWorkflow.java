package Order.WorkFlow_Template;

import Billing.BillGenerator;
import DiscountHandling_strategy.DiscountStrategy;
import Menu.MenuItemVariations_AbstractFactory.MenuItem;
import PaymentBilling_strategy.PaymentStrategy;

public abstract class OrderWorkflow {
    protected MenuItem item;
    protected DiscountStrategy discount;
    protected PaymentStrategy payment;
    protected BillGenerator billGen = new BillGenerator();

    public final void processOrder() {
        selectItem();
        double total = calculateTotal();
        total = discount.calculateDiscount(total);
        billGen.generateBill(item.getName(), total);
        payment.pay(total);
        notifyKitchenAndWaiter();
    }

    protected abstract void selectItem();
    protected abstract void notifyKitchenAndWaiter();

    protected double calculateTotal() { return item.getPrice(); }
}
