package Billing;

public class CashPayment implements PaymentStrategy {
    @Override
    public boolean pay(double amount) {
        System.out.println("Paid $" + amount + " in Cash.");
        return true;
    }
}