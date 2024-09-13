package org.example;

import static org.example.Constants.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OwnerAndSupplier extends User {

    private final HashMap<String, Product> products;


    public OwnerAndSupplier(String name, String displayName, String email, String password, String address, String phone) {
        super(name, displayName, email, password, address, phone);
        products = new HashMap<>();
    }

    public HashMap<String, Product> getProducts() {
        return products;
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