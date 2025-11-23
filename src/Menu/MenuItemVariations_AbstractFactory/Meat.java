package Menu.MenuItemVariations_AbstractFactory;

public class Meat implements MenuComponent {
    private final String name;
    private final double price;

    public Meat(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override public String getName() { return name; }
    @Override public double getPrice() { return price; }
}

