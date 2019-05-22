package com.example.demo.Model;

import javax.persistence.Entity;

@Entity
public class User extends Person {

    //Constructor containing all the fields from the Person super class
    //Setting permission to 0 to indicate that this Person is a User
    public User(int personID, String username, String passwordPerson, String email,
                byte[] picture, String description) {
        super(personID, username, passwordPerson, email, picture, description);
        setPermission(0);
    }


}
