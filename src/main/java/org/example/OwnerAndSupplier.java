package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OwnerAndSupplier extends User {
    private final List<Message> sentMessages;
    private final List<Message> readMessages;
    private final List<Message> unreadMessages;
    private final HashMap<String, Product> products;
    public static final String INVALID_NAME_MESSAGE = "Name is invalid";
    public static final String INVALID_PRICE_MESSAGE = "Price is invalid";
    public static final String INVALID_QUANTITY_MESSAGE = "Quantity is invalid";
    public static final String INVALID_PERMISSION_MESSAGE = "Permission is invalid";
    public static final String SUCCESSFUL_OPERATION = "successful operation";
    public static final String RECEIVER_DOESNT_EXIST = "receiver does not exist";
    public static final String INVALID_BARCODE = "barcode is invalid";

    public OwnerAndSupplier(String name, String displayName, String email, String password, String address, String phone) {
        super(name, displayName, email, password, address, phone);
        sentMessages = new ArrayList<>();
        readMessages = new ArrayList<>();
        unreadMessages = new ArrayList<>();
        products = new HashMap<>();
    }

    public List<Message> getSentMessages() {
        return sentMessages;
    }

    public List<Message> getReadMessages() {
        return readMessages;
    }

    public List<Message> getUnreadMessages() {
        return unreadMessages;
    }

    public HashMap<String, Product> getProducts() {
        return products;
    }

    public String sendMessage(String content, String name) {
        Message message = new Message(getName(), name, content);
        OwnerAndSupplier receiver = getOwnerSupplier(name);
        if (receiver == null) {
            return RECEIVER_DOESNT_EXIST;
        }
        sentMessages.add(message);
        receiver.receiveMessage(message);
        return SUCCESSFUL_OPERATION;
    }

    public void receiveMessage(Message message) {
        unreadMessages.add(message);
    }

    public void readUnreadMessages() {
        while (!unreadMessages.isEmpty()) {
            Message message = unreadMessages.get(unreadMessages.size() - 1);
            System.out.println(message);
            unreadMessages.remove(unreadMessages.size() - 1);
            readMessages.add(message);
        }
    }

    public static OwnerAndSupplier getOwnerSupplier(String name) {
        return (OwnerAndSupplier) nameMap.getOrDefault(name, null);
    }

    public void showProducts() {
        for (Product product : products.values()) {
            System.out.println(product.getName() + "\t" + product.getDescription() + "\t" + product.getPrice() + "\t" + product.getQuantity());
        }
    }

    public String increaseProductQuantity(String barcode, int quantity) {
        if (quantity < 0) return INVALID_QUANTITY_MESSAGE;
        if(products.containsKey(barcode)) {
            Product product = products.get(barcode);
            product.setQuantity(product.getQuantity() + quantity);
            return SUCCESSFUL_OPERATION;
        }
        return INVALID_BARCODE;
    }

    public String addNewProduct(String barcode, String name, String description, double price, int quantity) {
        if (price < 0) return INVALID_PRICE_MESSAGE;
        if(quantity < 0) return INVALID_QUANTITY_MESSAGE;
        if(products.containsKey(barcode)) {
            Product product = products.get(barcode);
            product.setQuantity(product.getQuantity() + quantity);
            return SUCCESSFUL_OPERATION;
        }
        Product product = new Product(barcode, name, description, price, quantity);
        products.put(barcode, product);
        return SUCCESSFUL_OPERATION;
    }

    public String updateProduct(String barcode, String name, String description, double price, int quantity) {
        if (price < 0) return INVALID_PRICE_MESSAGE;
        if (quantity < 0) return INVALID_QUANTITY_MESSAGE;
        if(products.containsKey(barcode)) {
            Product product = products.get(barcode);
            product.setName(name);
            product.setDescription(description);
            product.setPrice(price);
            product.setQuantity(quantity);
            return SUCCESSFUL_OPERATION;
        }
        return INVALID_BARCODE;
    }

    public String deleteProduct(String barcode) {
        products.remove(barcode);
        return SUCCESSFUL_OPERATION;
    }
}