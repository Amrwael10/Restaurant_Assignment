package Menu.MultipleMenuTypes_Factory;
import Menu.MenuItemVariations_AbstractFactory.MenuItem;

public interface MenuFactory {
    MenuItem createPizza();
    MenuItem createBurger();
}
