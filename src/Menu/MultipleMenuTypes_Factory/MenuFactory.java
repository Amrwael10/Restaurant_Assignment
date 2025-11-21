package Menu.MultipleMenuTypes_Factory;
import Menu.MenuItemVariations_AbstractFactory.MenuComponent;


public interface MenuFactory {
MenuComponent createPizza(String variant);
MenuComponent createBurger(String variant);
MenuComponent createBeverage(String variant);
}
