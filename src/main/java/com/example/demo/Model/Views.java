package com.example.demo.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Views {

    @Id
    //fields
    //formatting for Date
    java.util.Date dt = new java.util.Date();
    java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private int viewsID;
    private int postID;
    private Person person;
    private String timestamp = sdf.format(dt);

    //Empty Constructor
    public Views() {
    }

    // Default constructor
    public Views(int viewsID, int postID, Person person, String timestamp) {
        this.viewsID = viewsID;
        this.postID = postID;
        this.person = person;
        this.timestamp = timestamp;
    }

    // Accesors and Mutators
    public int getViewsID() {
        return viewsID;
    }

    public void setViewsID(int viewsID) {
        this.viewsID = viewsID;
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
