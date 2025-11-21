package Menu.CustomizableAddOns_decorator;
import Menu.MenuItemVariations_AbstractFactory.MenuComponent;


public abstract class AddOn implements MenuComponent {
    protected MenuComponent baseItem;
    public AddOn(MenuComponent baseItem) {
        this.baseItem = baseItem;
    }
}