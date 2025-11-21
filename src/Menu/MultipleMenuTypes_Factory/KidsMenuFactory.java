package Menu.MultipleMenuTypes_Factory;
import Menu.MenuItemVariations_AbstractFactory.MenuComponent;
import Menu.MenuItemVariations_AbstractFactory.MenuItem;

class KidsMenuFactory implements MenuFactory {
public MenuComponent createPizza(String variant) { return new MenuItem("Kids Pizza", 4.0); }
public MenuComponent createBurger(String variant) { return new MenuItem("Kids Burger", 3.5); }
public MenuComponent createBeverage(String variant) { return new MenuItem("Juice", 1.0); }
}