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
    private Person person;
    private String timestamp = sdf.format(dt);

    //Empty Constructor
    public Views() {
    }

    //Constructor containing all fields
    public Views(int viewsID, Person person, String timestamp) {
        this.viewsID = viewsID;
        this.person = person;
        this.timestamp = timestamp;
    }

    // Accessors and Mutators
    public int getViewsID() {
        return viewsID;
    }

    public void setViewsID(int viewsID) {
        this.viewsID = viewsID;
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
