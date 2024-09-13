package org.example;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Message {
    String senderName;
    String receiverName;
    LocalDateTime time;
    String content;

    public Message(String senderName, String receiverName, String content) {
        this.senderName = senderName;
        this.receiverName = receiverName;
        this.content = content;
        this.time = LocalDateTime.now();
    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return "Sender: " +
                senderName +
                "\nReceiver: " +
                receiverName +
                "\nTimestamp: " +
                DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss").format(time) +
                "\nMessage: " +
                content +
                "\n";
    }
}
