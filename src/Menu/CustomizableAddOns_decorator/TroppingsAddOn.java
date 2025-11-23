package Menu.CustomizableAddOns_decorator;
import Menu.MenuItemVariations_AbstractFactory.MenuComponent;


public class TroppingsAddOn extends AddOn{

    public TroppingsAddOn(MenuComponent baseItem) {
        super(baseItem);
    }

    @Override public String getName() { return baseItem.getName() + " With Extra Toppings"; }
    @Override public double getPrice() { return baseItem.getPrice() + 2.0; }
}
