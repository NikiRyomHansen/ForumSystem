package com.example.demo.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
public class Dislikes {

    @Id
    //fields
    //The following two lines are used for when a date has to be read from the database.
    private java.util.Date dt = new java.util.Date();
    private java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private int dislikeID;
    private int postID;
    private Person person;
    private String timestamp = sdf.format(dt);
    private String dislikeMessage;

    //Empty Constructor
    public Dislikes() {
    }

    // Default constructor
    public Dislikes(int dislikeID, int postID, Person person, String timestamp, String dislikeMessage) {
        this.dislikeID = dislikeID;
        this.postID = postID;
        this.person = person;
        this.timestamp = timestamp;
        this.dislikeMessage = dislikeMessage;
    }

    // Mutators and Accessors
    public int getDislikeID() {
        return dislikeID;
    }

    public void setDislikeID(int dislikeID) {
        this.dislikeID = dislikeID;
    }

    public int getPostID() {
        return postID;
    }

    public void setPostID(int postID) {
        this.postID = postID;
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
