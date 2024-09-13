package abd.sweetsystem;

import java.util.ArrayList;
import java.util.List;

public class Supplier extends OwnerAndSupplier {
    private final List<Order> orders = new ArrayList<>();
    public Supplier(String name, String email, String password, String type, String address, String phone) {
        super(name, email, password, type, address, phone);
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void receiveOrder(Order order) {
        order.setOrderStatus("received");
        orders.add(order);
    }

    public void endOrder(Order order) {
        order.setOrderStatus("done");
        orders.remove(order);
    }
}
