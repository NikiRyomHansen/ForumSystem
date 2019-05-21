package com.example.demo.Model;

import javax.persistence.Entity;

@Entity
public class Admin extends Person {

    //Constructor containing all fields from Person super class
    public Admin(int personID, String username, String passwordPerson, String email,
                 byte[] picture, String description, int permission) {
        super(personID, username, passwordPerson, email, picture, description, permission);
    }


}
