import PaymentSystem_straegy.*;
import RestaurantSystem_Facade.RestaurantSystemFacade;
import Menu.CustomizableAddOns_decorator.*;
import Menu.MenuItemVariations_AbstractFactory.MenuComponent;
import Order.WorkFlow_Template.OrderBuilder;
import Order.WorkFlow_Template.OrderDetails;
import DiscountHandling_strategy.*;

import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final RestaurantSystemFacade facade = new RestaurantSystemFacade();
    private static OrderBuilder currentOrder;

    public static void main(String[] args) {
        System.out.println("╔═══════════════════════════════════════════════╗");
        System.out.println("║   WELCOME TO RESTAURANT ORDERING SYSTEM       ║");
        System.out.println("╚═══════════════════════════════════════════════╝");

        currentOrder = facade.newOrder();
        boolean ordering = true;

        while (ordering) {
            displayMainMenu();
            int choice = getIntInput("Enter your choice: ");

            switch (choice) {
                case 1 -> facade.displayFullMenu();
                case 2 -> addItemToOrder();
                case 3 -> viewCurrentOrder();
                case 4 -> selectOrderType();
                case 5 -> ordering = !checkoutOrder();
                case 6 -> {
                    System.out.println("\nThank you for visiting! Goodbye!");
                    ordering = false;
                }
                default -> System.out.println("❌ Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }

    private static void displayMainMenu() {
        System.out.println("\n╔═══════════════════════════════════════════════╗");
        System.out.println("║              MAIN MENU                        ║");
        System.out.println("╠═══════════════════════════════════════════════╣");
        System.out.println("║  1. Display Full Menu                         ║");
        System.out.println("║  2. Add Item to Order                         ║");
        System.out.println("║  3. View Current Order                        ║");
        System.out.println("║  4. Select Order Type                         ║");
        System.out.println("║  5. Checkout & Pay                            ║");
        System.out.println("║  6. Exit                                      ║");
        System.out.println("╚═══════════════════════════════════════════════╝");
    }

    private static void addItemToOrder() {
        System.out.println("\n--- SELECT MENU FAMILY ---");
        System.out.println("1. Vegetarian Menu");
        System.out.println("2. Non-Vegetarian Menu");
        System.out.println("3. Kids Menu");
        int familyChoice = getIntInput("Enter menu family (1-3): ");

        String family = switch (familyChoice) {
            case 1 -> "veg";
            case 2 -> "nonveg";
            case 3 -> "kids";
            default -> {
                System.out.println("❌ Invalid family choice.");
                yield null;
            }
        };

        if (family == null) return;

        System.out.println("\n--- SELECT ITEM TYPE ---");
        System.out.println("1. Pizza");
        System.out.println("2. Burger");
        System.out.println("3. Beverage");
        int typeChoice = getIntInput("Enter item type (1-3): ");

        String type = switch (typeChoice) {
            case 1 -> "pizza";
            case 2 -> "burger";
            case 3 -> "beverage";
            default -> {
                System.out.println("❌ Invalid type choice.");
                yield null;
            }
        };

        if (type == null) return;

        String variant = selectVariant(family, type);
        MenuComponent item = facade.getMenuItem(family, type, variant);

        if (item == null) {
            System.out.println("❌ Item not available.");
            return;
        }

        // Add customizations (only for pizza/burger, not beverages)
        if (!type.equals("beverage")) {
            item = addCustomizations(item);
        } else {
            item = selectBeverageFlavor(item);
        }

        currentOrder.addItem(item);
        System.out.println("✅ Added: " + item.getName() + " - $" + item.getPrice());

        // Notify kitchen and waiter immediately after adding an item
        OrderDetails tempOrder = currentOrder.build();
        System.out.println("\n📢 Notifying Kitchen and Waiter about new item...");
        facade.notifyStaff(tempOrder);

        // Rebuild to continue
        currentOrder = facade.newOrder();
        for (MenuComponent existingItem : tempOrder.getItems()) {
            currentOrder.addItem(existingItem);
        }
        if (tempOrder.getOrderType() != null) {
            currentOrder.orderType(tempOrder.getOrderType());
        }
    }

    private static String selectVariant(String family, String type) {
        if (type.equals("pizza")) {
            if (family.equals("veg")) {
                System.out.println("\n--- SELECT PIZZA VARIANT ---");
                System.out.println("1. Italian");
                System.out.println("2. Classic");
                int choice = getIntInput("Enter variant (1-2): ");
                return choice == 1 ? "italian" : "classic";
            } else if (family.equals("nonveg")) {
                System.out.println("\n--- SELECT PIZZA VARIANT ---");
                System.out.println("1. Eastern");
                System.out.println("2. Classic");
                int choice = getIntInput("Enter variant (1-2): ");
                return choice == 1 ? "eastern" : "classic";
            }
        }
        return "classic";
    }

    private static MenuComponent addCustomizations(MenuComponent item) {
        boolean addingCustomizations = true;

        while (addingCustomizations) {
            System.out.println("\n--- ADD CUSTOMIZATIONS ---");
            System.out.println("Current item: " + item.getName() + " - $" + item.getPrice());
            System.out.println("1. Add Extra Cheese (+$1.5)");
            System.out.println("2. Add Extra Sauce (+$0.75)");
            System.out.println("3. Add Extra Toppings (+$2.0)");
            System.out.println("4. Done with customizations");

            int choice = getIntInput("Enter choice (1-4): ");

            switch (choice) {
                case 1 -> {
                    item = new CheeseAddOn(item);
                    System.out.println("✅ Added Extra Cheese");
                }
                case 2 -> {
                    item = new SaucesAddOn(item);
                    System.out.println("✅ Added Extra Sauce");
                }
                case 3 -> {
                    item = new TroppingsAddOn(item);
                    System.out.println("✅ Added Extra Toppings");
                }
                case 4 -> addingCustomizations = false;
                default -> System.out.println("❌ Invalid choice.");
            }
        }

        return item;
    }

    private static MenuComponent selectBeverageFlavor(MenuComponent item) {
        System.out.println("\n--- SELECT BEVERAGE FLAVOR ---");
        System.out.println("1. Apple Juice");
        System.out.println("2. Orange Juice");
        System.out.println("3. Mango Juice");
        System.out.println("4. Pineapple Juice");
        System.out.println("5. No specific flavor (keep as is)");

        int choice = getIntInput("Enter flavor choice (1-5): ");

        String flavor = switch (choice) {
            case 1 -> " - Apple Flavor";
            case 2 -> " - Orange Flavor";
            case 3 -> " - Mango Flavor";
            case 4 -> " - Pineapple Flavor";
            default -> "";
        };

        if (!flavor.isEmpty()) {
            // Create a new menu item with the flavor added to name
            final String baseName = item.getName();
            final double basePrice = item.getPrice();
            final String flavorName = flavor;

            item = new MenuComponent() {
                @Override
                public String getName() {
                    return baseName + flavorName;
                }

                @Override
                public double getPrice() {
                    return basePrice;
                }
            };
            System.out.println("✅ Selected: " + flavor.substring(3)); // Remove " - " prefix
        }

        return item;
    }

    private static void viewCurrentOrder() {
        OrderDetails tempOrder = currentOrder.build();

        if (tempOrder.getItems().isEmpty()) {
            System.out.println("\n📋 Your order is empty.");
            return;
        }

        System.out.println("\n╔═══════════════════════════════════════════════╗");
        System.out.println("║           YOUR CURRENT ORDER                  ║");
        System.out.println("╚═══════════════════════════════════════════════╝");

        int itemNum = 1;
        for (MenuComponent item : tempOrder.getItems()) {
            System.out.printf("%d. %-40s $%.2f%n", itemNum++, item.getName(), item.getPrice());
        }

        System.out.println("─────────────────────────────────────────────────");
        System.out.printf("SUBTOTAL: $%.2f%n", tempOrder.getTotal());
        System.out.println("═════════════════════════════════════════════════\n");

        // Rebuild the order to continue adding items
        currentOrder = facade.newOrder();
        for (MenuComponent item : tempOrder.getItems()) {
            currentOrder.addItem(item);
        }
        if (tempOrder.getOrderType() != null) {
            currentOrder.orderType(tempOrder.getOrderType());
        }
    }

    private static void selectOrderType() {
        System.out.println("\n--- SELECT ORDER TYPE ---");
        System.out.println("1. Dine-In");
        System.out.println("2. Takeaway");
        System.out.println("3. Delivery");

        int choice = getIntInput("Enter order type (1-3): ");

        String orderType = switch (choice) {
            case 1 -> "DINE-IN";
            case 2 -> "TAKEAWAY";
            case 3 -> "DELIVERY";
            default -> {
                System.out.println("❌ Invalid choice. Defaulting to Dine-In.");
                yield "DINE-IN";
            }
        };

        currentOrder.orderType(orderType);
        System.out.println("✅ Order type set to: " + orderType);
    }

    private static boolean checkoutOrder() {
        OrderDetails order = currentOrder.build();

        if (order.getItems().isEmpty()) {
            System.out.println("\n❌ Cannot checkout with an empty order.");
            return false;
        }

        if (order.getOrderType() == null) {
            System.out.println("\n⚠️  Order type not selected. Defaulting to Dine-In.");
            currentOrder.orderType("DINE-IN");
            order = currentOrder.build();
        }

        // Display order summary
        System.out.println("\n╔═══════════════════════════════════════════════╗");
        System.out.println("║              ORDER SUMMARY                    ║");
        System.out.println("╚═══════════════════════════════════════════════╝");

        for (MenuComponent item : order.getItems()) {
            System.out.printf("%-40s $%.2f%n", item.getName(), item.getPrice());
        }
        System.out.println("─────────────────────────────────────────────────");
        System.out.printf("SUBTOTAL: $%.2f%n", order.getTotal());

        // Auto-apply best discount based on order contents
        DiscountStrategy discount = determineDiscount(order);
        double discountAmount = discount.calculateDiscount(order);

        if (discountAmount > 0) {
            System.out.printf("DISCOUNT: -$%.2f (Auto-applied)%n", discountAmount);
        } else {
            System.out.println("DISCOUNT: -$0.00 (No applicable discount)");
        }

        double finalAmount = order.getTotal() - discountAmount;
        System.out.printf("TOTAL: $%.2f%n", finalAmount);
        System.out.println("═════════════════════════════════════════════════");

        // Select payment method
        PaymentStrategy payment = selectPaymentMethod();
        String paymentMethodName = getPaymentMethodName(payment);

        // Process checkout - simplified output
        System.out.println("\n🔄 Processing payment...");
        System.out.printf("Payment Method: %s%n", paymentMethodName);
        System.out.printf("Total Amount: $%.2f%n", finalAmount);

        boolean success = facade.checkout(order, payment, discount);

        if (success) {
            System.out.println("📢 Final order confirmation sent to Kitchen and Waiter!");
            System.out.println("\n✅ ORDER PLACED SUCCESSFULLY!");
            System.out.println("Order ID: " + order.getId());
            System.out.println("Order Type: " + order.getOrderType());
            System.out.println("\nThank you for your order!");

            // Reset for new order
            currentOrder = facade.newOrder();
            return true;
        } else {
            System.out.println("\n❌ Payment failed. Please try again.");
            return false;
        }
    }

    private static String getPaymentMethodName(PaymentStrategy payment) {
        if (payment instanceof CashPayment) {
            return "Cash";
        } else if (payment instanceof CreditCardPayment) {
            return "Credit Card";
        } else if (payment instanceof InstaPayPayment) {
            return "InstaPay";
        }
        return "Unknown";
    }

    /**
     * Automatically determines the best discount based on order contents.
     * Priority: Meat (20%) > Burger (15%) > Pizza (10%)
     */
    private static DiscountStrategy determineDiscount(OrderDetails order) {
        double meatDiscount = new MeatDiscount().calculateDiscount(order);
        double BurgerDiscount = new BurgerDiscount().calculateDiscount(order);
        double pizzaDiscount = new PizzaDiscount().calculateDiscount(order);

        // Apply the discount that gives the highest savings
        if (meatDiscount > 0 && meatDiscount >= BurgerDiscount && meatDiscount >= pizzaDiscount) {
            System.out.println("💰 Best discount: MEAT DISCOUNT (20% off meat items)");
            return new MeatDiscount();
        } else if (BurgerDiscount > 0 && BurgerDiscount >= pizzaDiscount) {
            System.out.println("💰 Best discount: BURGER DISCOUNT (15% off burger items)");
            return new BurgerDiscount();
        } else if (pizzaDiscount > 0) {
            System.out.println("💰 Best discount: PIZZA DISCOUNT (10% off pizza items)");
            return new PizzaDiscount();
        }

        System.out.println("ℹ️  No applicable discounts for this order");
        return new NoDiscount();
    }

    private static PaymentStrategy selectPaymentMethod() {
        System.out.println("\n--- SELECT PAYMENT METHOD ---");
        System.out.println("1. Cash");
        System.out.println("2. Credit Card");
        System.out.println("3. InstaPay (Mobile Wallet)");

        int choice = getIntInput("Enter payment method (1-3): ");

        return switch (choice) {
            case 2 -> new CreditCardPayment();
            case 3 -> new InstaPayPayment();
            default -> new CashPayment();
        };
    }

    private static int getIntInput(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            System.out.print("Invalid input. " + prompt);
            scanner.next();
        }
        int input = scanner.nextInt();
        scanner.nextLine(); // consume newline
        return input;
    }
}