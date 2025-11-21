package Menu.MenuItemVariations_AbstractFactory;

public class Pizza implements MenuComponent {
    private final String name;
    private final double price;

    public Pizza(String name, double price) { // Italian, Mexican, Eastern, for Vegans ...
        this.name = name;
        this.price = price;
    }

    @Override public String getName() { return name; }
    @Override public double getPrice() { return price; }
}
