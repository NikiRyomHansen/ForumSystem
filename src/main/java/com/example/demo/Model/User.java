package com.example.demo.Model;

import javax.persistence.Entity;

@Entity
public class User extends Person {

    //Constructort containing all the fields from the Person super class
    //Setting permission to 0 to indicate that this Person is a User
    public User(int personID, String personUsername, String personPassword, String email,
                byte[] picture, String personDescription) {
        super(personID, personUsername, personPassword, email, picture, personDescription);
        setPermission(0);

    }

}
