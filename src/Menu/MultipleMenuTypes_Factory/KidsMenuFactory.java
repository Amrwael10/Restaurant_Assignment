package Menu.MultipleMenuTypes_Factory;

import Menu.MenuItemVariations_AbstractFactory.Burger;
import Menu.MenuItemVariations_AbstractFactory.MenuItem;
import Menu.MenuItemVariations_AbstractFactory.Pizza;

public class KidsMenuFactory implements MenuFactory {
    public MenuItem createPizza() { return new Pizza("Mini Pizza", 5.0); }
    public MenuItem createBurger() { return new Burger("Kids Burger", 4.0); }
}
