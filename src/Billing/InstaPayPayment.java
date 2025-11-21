package Billing;

public class InstaPayPayment implements PaymentStrategy{
    @Override
    public boolean pay(double amount) {
        System.out.println("Paid $" + amount + " in InstaPay.");
        return true;
    }
}
