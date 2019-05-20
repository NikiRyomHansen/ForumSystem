package com.example.demo.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Dislikes {

    @Id
    //fields
    //formatting for Date
    java.util.Date dt = new java.util.Date();
    java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private int dislikeID;
    private Person person;
    private String timestamp = sdf.format(dt);
    private String dislikeMessage;

    //Empty Constructor
    public Dislikes() {
    }

    //Constructor containing all fields
    public Dislikes(int dislikeID, Person person, String timestamp, String dislikeMessage) {
        this.dislikeID = dislikeID;
        this.person = person;
        this.timestamp = timestamp;
        this.dislikeMessage = dislikeMessage;
    }

    public int getDislikeID() {
        return dislikeID;
    }

    public void setDislikeID(int dislikeID) {
        this.dislikeID = dislikeID;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getDislikeMessage() {
        return dislikeMessage;
    }

    public void setDislikeMessage(String dislikeMessage) {
        this.dislikeMessage = dislikeMessage;
    }
}
