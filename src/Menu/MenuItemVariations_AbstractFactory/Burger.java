package Menu.MenuItemVariations_AbstractFactory;

public class Burger implements MenuItem {
    private final String name;
    private final double price;

    public Burger(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override public String getName() { return name; }
    @Override public double getPrice() { return price; }
}
