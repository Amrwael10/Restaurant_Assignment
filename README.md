#Restaurant Ordering & Billing System Assignment

# **Restaurant Ordering & Billing System (Java Implementation)**

This project implements a modular and extensible Restaurant Ordering & Billing System using Java and adhering strictly to SOLID principles and established Object-Oriented Design Patterns.

## **Project Structure**

The project is organized to reflect the different subsystems and the application of design patterns:

* **com.restaurant.core**: Core classes (Order, Billing, MenuItem).
* **com.restaurant.menu**: Menu-related interfaces and factories (Factory Method, Abstract Factory).
* **com.restaurant.addons**: Decorator pattern components for item customization.
* **com.restaurant.strategy**: Strategy pattern components (DiscountStrategy, PaymentMethod).
* **com.restaurant.notification**: Observer pattern components (OrderNotifier).
* **com.restaurant.workflow**: Template Method pattern components (OrderingWorkflow).
* **com.restaurant.facade**: Facade pattern implementation (RestaurantFacade).
* **com.restaurant.main**: Entry point and demonstration of the system's functionality.

## **Prerequisites**

* Java Development Kit (JDK) 17 or higher.
* A Java IDE (IntelliJ IDEA, Eclipse, VS Code with Java extensions) or a build tool like Maven/Gradle.

## **Running the Project**

1. **Compile:** Compile all Java source files.
2. **Run:** Execute the Main class within the com.restaurant.main package.

The Main class contains demonstration logic that runs through the scenarios detailed below, printing the output to the console.

## **Example Test Cases and Scenarios**

The following scenarios demonstrate the system's core functionality, including order creation, customization (Decorator), dynamic pricing (Strategy), and notification (Observer).

### **Scenario 1: Standard Dine-In Order (Cash Payment, No Discount)**

**Goal:** Place a simple order and process payment with no special conditions.

| Step | Action | Expected Outcome |
| :---- | :---- | :---- |
| **Order 1** | Select Classic Burger (Base Price: 12.00) | Item added to order. |
| **Billing** | Select CashPayment strategy. | Payment is processed; receipt generated. |
| **Notification** | Order placed. | KitchenSystem and WaiterSystem observers are notified. |
| **Total** | Base Price: 12.00. Tax (10%): 1.20. **Final Total: 13.20**. | Correct total calculated and displayed. |

### **Scenario 2: Customizable Pizza Order with Discount (Credit Card Payment)**

**Goal:** Demonstrate Decorator (add-ons) and Discount Strategy application.

| Step | Action | Pattern Used | Expected Outcome |
| :---- | :---- | :---- | :---- |
| **Order 2** | Create Eastern Pizza (Base Price: 25.00) using the EasternPizzaFactory. | Abstract Factory | Base pizza item created. |
| **Customization** | Add Extra Cheese (+3.00) and Special Topping (+4.00). | Decorator | Total item price becomes 32.00. |
| **Discount** | Apply PizzaDiscount (10% off the pizza item). | Strategy | Discount of 3.20 is applied. |
| **Billing** | Select CreditCardPayment strategy. | Strategy | Payment processed securely. |
| **Total** | Item Price: 32.00. Discount: 3.20. Subtotal: 28.80. Tax (10%): 2.88. **Final Total: 31.68**. | Discount is calculated before tax and applied correctly. |  |

### **Scenario 3: Kids Meal Order (Mobile Wallet Payment)**

**Goal:** Demonstrate a different menu type and a full workflow.

| Step | Action | Pattern Used | Expected Outcome |
| :---- | :---- | :---- | :---- |
| **Workflow** | Initiate DineInWorkflow. | Template Method | The sequence of steps is guaranteed. |
| **Order 3** | Select Kids Pasta (Base Price: 8.00) from the KidsMenu. | Factory Method | Item added to order. |
| **Billing** | Select MobileWalletPayment strategy. | Strategy | Mobile payment processing simulation executed. |
| **Notification** | Order placed. | Observer | Kitchen and Waiter systems receive the full order details. |

## **Design Pattern Highlights**

The system uses the **Strategy pattern** extensively to manage variability. This pattern is crucial for both discounts and payment processing, allowing the Billing component to be agnostic of the specific logic used, promoting OCP.

The **Decorator pattern** allows flexible menu item customization. A base MenuItem can be wrapped in multiple decorator classes (e.g., ExtraSauceDecorator) to layer on costs and descriptions without modifying the original item class.

The **Abstract Factory pattern** is used for generating related product families. This pattern helps ensure consistency when ordering specific cuisine types.
