package org.example;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Order {
    private static int count = 0;
    private final int orderId;
    private String senderName;
    private String productName;
    private String supplierName;
    private int quantity;
    private String orderStatus;
    LocalDateTime time;
    public Order(String senderName, String supplierName, String orderStatus, int quantity, String productName) {
        this.orderId=count;
        count++;
        this.supplierName = supplierName;
        this.senderName = senderName;
        this.orderStatus = orderStatus;
        this.time = LocalDateTime.now();
        this.productName = productName;
        this.quantity = quantity;
    }

    public int getOrderId() {
        return orderId;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Override
    public String toString() {
        return "Sender: " +
                OwnerAndSupplier.getOwnerSupplier(senderName).getName() +
                "\nReceiver: " +
                OwnerAndSupplier.getOwnerSupplier(supplierName).getName() +
                "\nTimestamp: " +
                DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss").format(time) +
                "\nOrder: " + productName +
                "\nQuantity: " + quantity +
                "\nOrder Status: " + orderStatus;
    }
}
