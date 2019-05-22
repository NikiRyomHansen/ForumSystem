package com.example.demo.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

//superclass
@Entity
public class Person {

    @Id
    //fields
    private int personID;
    private String personUsername;
    private String personPassword;
    private String email;
    private byte[] picture;
    private String description;
    private int permission;

    //Empty Constructor
    public Person() {
    }

    //Constructor containing all fields except permission
    public Person(int personID, String personUsername, String personPassword, String email, byte[] picture, String description) {
        this.personID = personID;
        this.personUsername = personUsername;
        this.personPassword = personPassword;
        this.email = email;
        this.picture = picture;
        this.description = description;
    }

    //Constructor containing all fields
    public Person(int personID, String personUsername, String personPassword, String email, byte[] picture, String description, int permission) {
        this.personID = personID;
        this.personUsername = personUsername;
        this.personPassword = personPassword;
        this.email = email;
        this.picture = picture;
        this.description = description;
        this.permission = permission;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPermission() {
        return permission;
    }

    public void setPermission(int permission) {
        this.permission = permission;
    }
}
