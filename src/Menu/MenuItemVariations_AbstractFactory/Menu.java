package Menu.MenuItemVariations_AbstractFactory;

import java.util.ArrayList;
import java.util.List;

public class Menu implements MenuComponent{
    private final String name;
    private final List<MenuComponent> menuItems = new ArrayList<>();

    public Menu(String name) {
        this.name = name;
    }

    public void addItem(MenuComponent item) {
        menuItems.add(item);
    }

    public void removeItem(MenuComponent item) {
        menuItems.remove(item);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        throw new UnsupportedOperationException("no price");
    }

    public List<MenuComponent> getMenuItems() {
        return menuItems;
    }
}
