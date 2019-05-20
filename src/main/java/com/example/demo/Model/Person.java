package com.example.demo.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

//superclass
@Entity
public class Person {

    @Id
    //fields
    private int personID;
    private String username;
    private String passwordPerson;
    private String email;
    private byte[] picture;
    private String description;
    private int permission;

    //Empty Constructor
    public Person() {
    }

    //Constructor containing all fields
    public Person(int personID, String username, String passwordPerson, String email, byte[] picture, String description, int permission) {
        this.personID = personID;
        this.username = username;
        this.passwordPerson = passwordPerson;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswordPerson() {
        return passwordPerson;
    }

    public void setPasswordPerson(String passwordPerson) {
        this.passwordPerson = passwordPerson;
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
