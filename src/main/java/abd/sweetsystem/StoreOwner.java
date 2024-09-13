package abd.sweetsystem;

public class StoreOwner extends OwnerAndSupplier {
    public static final String NOT_AN_INSTANCE_MESSAGE = "Not an instance";
    public StoreOwner(String name, String email, String type, String password, String address, String phone) {
        super(name, email, password, type, address, phone);
    }

    public String requestOrder(String productName, String supplierName, int quantity) {
        OwnerAndSupplier supplier = getOwnerSupplier(supplierName);
        if (!(supplier instanceof Supplier supplier2)) return NOT_AN_INSTANCE_MESSAGE;
        if (quantity <= 0) return INVALID_QUANTITY_MESSAGE;
        Order order = new Order(getName(), supplierName, "pending", quantity, productName);
        supplier2.receiveOrder(order);
        return SUCCESSFUL_OPERATION;
    }
}