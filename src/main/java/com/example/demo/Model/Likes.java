package com.example.demo.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Likes {

    @Id
    //fields
    //The following two lines are used for when a date has to be read from the database.
    private java.util.Date dt = new java.util.Date();
    private java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private int likesID;
    private int postID;
    private Person person;
    private String timestamp = sdf.format(dt);

    //Empty Constructor
    public Likes() {
    }

    //Default Constructor
    public Likes(int likesID, int postID, Person person, String timestamp) {
        this.likesID = likesID;
        this.postID = postID;
        this.person = person;
        this.timestamp = timestamp;
    }

    // Accessors and Mutators.
    public int getLikesID() {
        return likesID;
    }

    public void setLikesID(int likesID) {
        this.likesID = likesID;
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
}
