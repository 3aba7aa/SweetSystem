package org.example;

import java.util.HashMap;

public class User {
    protected static final HashMap<String, User> nameMap = new HashMap<>();
    private final String name;
    private String displayName;
    private String email;
    private String password;
    private String address;
    private String phone;

    public User(String name, String displayName, String email, String password, String address, String phone) {
        this.name = name;
        nameMap.put(name, this);
        this.displayName = displayName;
        this.email = email;
        this.password = password;
        this.address = address;
        this.phone = phone;
    }

    public HashMap<String, User> getNameMap() {
        return nameMap;
    }

    public void setNameMap(HashMap<String, User> nameMap) {
        User.nameMap.clear();
        User.nameMap.putAll(nameMap);
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
