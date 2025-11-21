package Menu.MultipleMenuTypes_Factory;
import Menu.MenuItemVariations_AbstractFactory.MenuComponent;
import Menu.MenuItemVariations_AbstractFactory.MenuItem;

public class VegMenuFactory implements MenuFactory {
    @Override
    public MenuComponent createPizza(String variant) {
        if (variant.equalsIgnoreCase("italian")) {
            return new MenuItem("Veg Italian Pizza", 8.0);
        }
        return new MenuItem("Veg Classic Pizza", 6.5);
    }
    public MenuComponent createBurger(String variant) {
        return new MenuItem("Veg Burger", 5.0);
    }
    public MenuComponent createBeverage(String variant) {
        return new MenuItem("Soft Drink", 1.5);
    }
}