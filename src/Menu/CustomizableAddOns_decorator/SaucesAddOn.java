package Menu.CustomizableAddOns_decorator;
import Menu.MenuItemVariations_AbstractFactory.MenuItem;

public class SaucesAddOn extends AddOn {
    public SaucesAddOn(MenuItem baseItem) { super(baseItem); }

    @Override public String getName() { return baseItem.getName() + " With Extra Sauce"; }
    @Override public double getPrice() { return baseItem.getPrice() + 0.75; }
}