package Menu.MultipleMenuTypes_Factory;
import Menu.MenuItemVariations_AbstractFactory.Burger;
import Menu.MenuItemVariations_AbstractFactory.Pizza;
import Menu.MenuItemVariations_AbstractFactory.MenuItem;

public class VegMenuFactory implements MenuFactory {
    public MenuItem createPizza() { return new Pizza("Veggie Pizza", 7.5); }
    public MenuItem createBurger() { return new Burger("Veg Burger", 6.0); }
}
