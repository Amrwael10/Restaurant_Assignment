package Menu.MultipleMenuTypes_Factory;
import Menu.MenuItemVariations_AbstractFactory.MenuComponent;
import Menu.MenuItemVariations_AbstractFactory.MenuItem;

class VegetarianMenuFactory implements MenuFactory {
public MenuComponent createPizza(String variant) {
switch(variant.toLowerCase()) {
case "italian": return new MenuItem("Veg Italian Pizza", 8.0);
default: return new MenuItem("Veg Classic Pizza", 6.5);
}
}
public MenuComponent createBurger(String variant) {
return new MenuItem("Veg Burger", 5.0);
}
public MenuComponent createBeverage(String variant) { return new MenuItem("Soft Drink", 1.5); }
}