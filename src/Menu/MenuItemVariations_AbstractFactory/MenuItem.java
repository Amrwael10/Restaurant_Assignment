package Menu.MenuItemVariations_AbstractFactory;

public class MenuItem implements MenuComponent {
    protected String name;
    protected double price;
    public MenuItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String getName() { return name; }

    @Override
    public double getPrice() {return price;};
}
