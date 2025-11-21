package Menu.MultipleMenuTypes_Factory;
import Menu.MenuItemVariations_AbstractFactory.MenuItem;
import Menu.MenuItemVariations_AbstractFactory.MenuComponent;

class NonVegMenuFactory implements MenuFactory {
public MenuComponent createPizza(String variant) {
if (variant.equalsIgnoreCase("eastern")) return new MenuItem("Eastern Chicken Pizza", 9.0);
return new MenuItem("Chicken Classic Pizza", 8.5);
}
public MenuComponent createBurger(String variant) { return new MenuItem("Classic Burger", 6.0); }
public MenuComponent createBeverage(String variant) { return new MenuItem("Soft Drink", 1.5); }
}