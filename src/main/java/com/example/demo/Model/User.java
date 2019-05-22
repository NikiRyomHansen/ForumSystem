package com.example.demo.Model;

import javax.persistence.Entity;

@Entity
public class User extends Person {

    //Constructor containing all the fields from the Person super class
    public User(int personID, String username, String passwordPerson, String email,
                byte[] picture, String description, int permission) {
        super(personID, username, passwordPerson, email, picture, description, permission);

        //Får error uden indkludering af permission-!
    }
}
