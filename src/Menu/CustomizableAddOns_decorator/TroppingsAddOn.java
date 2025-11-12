package Menu.CustomizableAddOns_decorator;
import Menu.MenuItemVariations_AbstractFactory.MenuItem;

public class TroppingsAddOn extends AddOn{
    private MenuItem baseItem;

    public TroppingsAddOn(MenuItem baseItem) {
        super(baseItem);
    }

    @Override public String getName() { return baseItem.getName() + " With Extra Toppings"; }
    @Override public double getPrice() { return baseItem.getPrice() + 2.0; }
}
