package Billing;
public class CreditCardPayment implements PaymentStrategy{
    @Override
    public boolean pay(double amount) {
        System.out.println("Paid $" + amount + " in Credit Card.");
        return true;
    }
}
