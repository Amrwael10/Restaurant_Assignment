package Menu.MultipleMenuTypes_Factory;

import Menu.MenuItemVariations_AbstractFactory.Burger;
import Menu.MenuItemVariations_AbstractFactory.MenuItem;
import Menu.MenuItemVariations_AbstractFactory.Pizza;

public class NonVegMenuFactory implements MenuFactory {
    public MenuItem createPizza() { return new Pizza("Chicken Pizza", 8.5); }
    public MenuItem createBurger() { return new Burger("Beef Burger", 7.5); }
}