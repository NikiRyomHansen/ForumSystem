package com.example.demo.Model;

import javax.persistence.Entity;

@Entity
public class Admin extends Person {

    //Constructor containing all fields from Person super class
    //Setting permission to 1 to indicate that this Person is an Admin
    public Admin(int personID, String personUsername, String personPassword, String email,
                 byte[] picture, String personDescription) {
        super(personID, personUsername, personPassword, email, picture, personDescription);
        setPermission(1);
    }


}
