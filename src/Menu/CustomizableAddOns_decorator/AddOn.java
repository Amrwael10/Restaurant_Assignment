package Menu.CustomizableAddOns_decorator;
import Menu.MenuItemVariations_AbstractFactory.MenuItem;

public abstract class AddOn implements MenuItem {
    protected MenuItem baseItem;
    public AddOn(MenuItem baseItem) {
        this.baseItem = baseItem;
    }
}