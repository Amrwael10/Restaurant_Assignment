package Menu.CustomizableAddOns_decorator;
import Menu.MenuItemVariations_AbstractFactory.MenuItem;

public class CheeseAddOn extends AddOn {
    public CheeseAddOn(MenuItem baseItem) {
        super(baseItem);
    }

    @Override public String getName() { return baseItem.getName() + " With Extra Cheese"; }
    @Override public double getPrice() { return baseItem.getPrice() + 1.5; }
}