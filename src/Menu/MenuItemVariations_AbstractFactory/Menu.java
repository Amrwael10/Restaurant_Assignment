package Menu.MenuItemVariations_AbstractFactory;

import java.util.ArrayList;
import java.util.List;

public class Menu implements MenuItem{
    private final String name;
    private final List<MenuItem> menuItems = new ArrayList<>();

    public Menu(String name) {
        this.name = name;
    }

    public void addItem(MenuItem item) {
        menuItems.add(item);
    }

    public void removeItem(MenuItem item) {
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

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }
}
