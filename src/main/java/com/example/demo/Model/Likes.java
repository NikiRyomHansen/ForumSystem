package com.example.demo.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Likes {

    @Id
    //fields
    //formatting for Date
    java.util.Date dt = new java.util.Date();
    java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private int likesID;
    private Person person;
    private String timestamp = sdf.format(dt);

    //Empty Constructor
    public Likes() {
    }

    //Constructor containing all fields
    public Likes(int likesID, Person person, String timestamp) {
        this.likesID = likesID;
        this.person = person;
        this.timestamp = timestamp;
    }

    public int getLikesID() {
        return likesID;
    }

    public void setLikesID(int likesID) {
        this.likesID = likesID;
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
