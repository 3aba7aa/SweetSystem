package abd.sweetsystem;

public class Product {
    private final String barcode;
    private String name;
    private String description;
    private double price;
    private int quantity;

    public Product(String barcode, String name, String description, double price, int quantity) {
        Validate(barcode, name, price, quantity);
        this.barcode = barcode;
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

    public String getBarCode() {
        return barcode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void Validate(String barcode, String name, double price, int quantity) {
        checkBarCode(barcode);
        checkName(name);
        checkPrice(price);
        checkQuantity(quantity);
    }

    public void checkBarCode(String barCode) {
        if(barCode.length() != 13) {
            throw new IllegalArgumentException("Bar Code must be 13 characters");
        }
    }

    public void checkName(String name) {
        if(name.length() < 3) {
            throw new IllegalArgumentException("Name must be at least 3 characters");
        }
    }

    public void checkPrice(double price) {
        if(price <= 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }
    }

    public void checkQuantity(int quantity) {
        if(quantity < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative");
        }
    }
}
