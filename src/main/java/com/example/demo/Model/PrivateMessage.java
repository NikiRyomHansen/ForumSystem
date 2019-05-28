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

    private int privateMessageID;
    private int toUserID;
    private int fromUserID;
    private String headline;
    private String message;
    private String timestampPrivateMessage = sdf.format(dt);
    private boolean isRead;

    private int personID;
    private String personUsername;
    private String personPassword;
    private String email;
    private byte[] picture;
    private String personDescription;
    private int permission;

    //default constructor
    public PrivateMessage() {
    }

    // constructor
    public PrivateMessage(int privateMessageID, int toUserID, int fromUserID, String headline, String message, String timestampPrivateMessage, boolean isRead, String personUsername) {
        this.privateMessageID = privateMessageID;
        this.toUserID = toUserID;
        this.fromUserID = fromUserID;
        this.headline = headline;
        this.message = message;
        this.timestampPrivateMessage = timestampPrivateMessage;
        this.isRead = isRead;
    }

    // Constructor for the getAllPrivateMessages method all the information is needed to make the full join work
    public PrivateMessage(int privateMessageID, int toUserID, int fromUserID, String headline, String message, String timestampPrivateMessage, boolean isRead, int personID, String personUsername, String personPassword, String email, byte[] picture, String personDescription, int permission) {
        this.privateMessageID = privateMessageID;
        this.toUserID = toUserID;
        this.fromUserID = fromUserID;
        this.headline = headline;
        this.message = message;
        this.timestampPrivateMessage = timestampPrivateMessage;
        this.isRead = isRead;
        this.personID = personID;
        this.personUsername = personUsername;
        this.personPassword = personPassword;
        this.email = email;
        this.picture = picture;
        this.personDescription = personDescription;
        this.permission = permission;
    }

    // Setters and getter for privatemessage


    public int getPrivateMessageID() {
        return privateMessageID;
    }

    public void setPrivateMessageID(int privateMessageID) {
        this.privateMessageID = privateMessageID;
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

    public int getPersonID() {
        return personID;
    }

    public void setPersonID(int personID) {
        this.personID = personID;
    }

    public String getPersonUsername() {
        return personUsername;
    }

    public void setPersonUsername(String personUsername) {
        this.personUsername = personUsername;
    }

    public String getPersonPassword() {
        return personPassword;
    }

    public void setPersonPassword(String personPassword) {
        this.personPassword = personPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    public String getPersonDescription() {
        return personDescription;
    }

    public void setPersonDescription(String personDescription) {
        this.personDescription = personDescription;
    }

    public int getPermission() {
        return permission;
    }

    public void setPermission(int permission) {
        this.permission = permission;
    }
}