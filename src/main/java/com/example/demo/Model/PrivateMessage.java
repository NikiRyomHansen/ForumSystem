package com.example.demo.Model;

import org.springframework.data.annotation.Id;

import javax.persistence.Entity;

@Entity
public class PrivateMessage {


    @Id
    //fields
    // formatting for Date
    java.util.Date dt = new java.util.Date();
    java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private int privateMessage;
    private int toUserID;
    private int fromUserID;
    private String headline;
    private String message;
    private String timestampPrivateMessage = sdf.format(dt);
    private boolean isRead;

    //default constructor
    public PrivateMessage() {
    }

    // constructor
    public PrivateMessage(int privateMessage, int toUserID, int fromUserID, String headline, String message, String timestampPrivateMessage, boolean isRead) {
        this.privateMessage = privateMessage;
        this.toUserID = toUserID;
        this.fromUserID = fromUserID;
        this.headline = headline;
        this.message = message;
        this.timestampPrivateMessage = timestampPrivateMessage;
        this.isRead = isRead;
    }


    // Setters and getter for privatemessage
    public int getPrivateMessage() {
        return privateMessage;
    }

    public void setPrivateMessage(int privateMessage) {
        this.privateMessage = privateMessage;
    }

    public int getToUserID() {
        return toUserID;
    }

    public void setToUserID(int toUserID) {
        this.toUserID = toUserID;
    }

    public int getFromUserID() {
        return fromUserID;
    }

    public void setFromUserID(int fromUserID) {
        this.fromUserID = fromUserID;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTimestampPrivateMessage() {
        return timestampPrivateMessage;
    }

    public void setTimestampPrivateMessage(String timestampPrivateMessage) {
        this.timestampPrivateMessage = timestampPrivateMessage;
    }

    public boolean isRead() {
        return isRead;
    }

    public void setRead(boolean read) {
        isRead = read;
    }
}
