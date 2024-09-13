package abd.sweetsystem;

import static abd.sweetsystem.Constants.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class User {

    protected static final HashMap<String, User> nameMap = new HashMap<>();
    private final List<Message> sentMessages;
    private final List<Message> unreadMessages;
    private final List<Message> readMessages;
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
        sentMessages = new ArrayList<>();
        unreadMessages = new ArrayList<>();
        readMessages = new ArrayList<>();
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

    public static User getUser(String name) {
        return nameMap.getOrDefault(name, null);
    }

    public List<Message> getSentMessages() {
        return sentMessages;
    }

    public List<Message> getUnreadMessages() {
        return unreadMessages;
    }

    public List<Message> getReadMessages() {
        return readMessages;
    }

    public String sendMessage(String content, String name) {
        User receiver = getUser(name);
        if (receiver == null) {
            return RECEIVER_DOESNT_EXIST;
        }
        Message message = new Message(getName(), name, content);
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
}
